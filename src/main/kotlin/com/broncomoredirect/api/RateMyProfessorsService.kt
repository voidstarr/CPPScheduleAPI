package com.broncomoredirect.api

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.toInput
import com.apollographql.apollo.exception.ApolloException
import com.broncomoredirect.graphql.client.NewSearchTeachersQuery
import com.broncomoredirect.graphql.client.TeacherRatingsPageQuery
import com.broncomoredirect.graphql.client.type.TeacherSearchQuery
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.springframework.stereotype.Service
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@Service
class RateMyProfessorsService {
    val client = ApolloClient.builder()
        .serverUrl("https://www.ratemyprofessors.com/graphql")
        .okHttpClient(
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Basic dGVzdDp0ZXN0")
                        .build()
                    chain.proceed(request)
                }
                .build())
        .build()


    fun getProfessorRating(professorLast: String, professorFirst: String): ProfessorRatingDto {
        var response: String?
        val searchResponse = runBlocking {
            client.query(
                NewSearchTeachersQuery(
                    TeacherSearchQuery(
                        text = "$professorFirst $professorLast".toInput(),
                        schoolID = "U2Nob29sLTE0Nzc0".toInput()
                    )
                )
            ).execute()
        }

        val id = searchResponse.data?.newSearch?.teachers?.edges?.get(0)?.node?.id.toString()
        val legacyId = searchResponse.data?.newSearch?.teachers?.edges?.get(0)?.node?.legacyId.toString()
        var teacherRatingPage = runBlocking { client.query(TeacherRatingsPageQuery(id)).execute() }.data?.node

        return ProfessorRatingDto(
            professorFirst,
            professorLast,
            id,
            legacyId,
            teacherRatingPage?.asTeacher?.fragments?.featuredRatings_teacher?.avgRating.toString()
        )
    }
}

data class ProfessorRatingDto(
    val professorFirst: String,
    val professorLast: String,
    val id: String,
    val legacyId: String,
    val ProfessorRating: String
)

suspend fun <T> ApolloCall<T>.execute() = suspendCoroutine<Response<T>> { continuation ->
    enqueue(object : ApolloCall.Callback<T>() {
        override fun onResponse(response: Response<T>) {
            continuation.resume(response)
        }

        override fun onFailure(error: ApolloException) {
            continuation.resumeWithException(error)
        }
    })
}

