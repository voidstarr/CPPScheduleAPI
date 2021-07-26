package com.cs4080.cppscheduleapi

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.DomElement
import com.gargoylesoftware.htmlunit.html.HtmlOrderedList
import com.gargoylesoftware.htmlunit.html.HtmlPage
import org.springframework.stereotype.Service

@Service
class CPPScheduleService {
    fun getSections(searchParameters: Map<String, String>): List<SectionDataDto> {//TODO
        val sectionList = ArrayList<SectionDataDto>()
        val webClient = WebClient(BrowserVersion.BEST_SUPPORTED)
        webClient.options.isCssEnabled = false;
        webClient.options.isJavaScriptEnabled = false;
        val searchPage = webClient.getPage<HtmlPage>("https://schedule.cpp.edu")

        searchParameters.forEach { searchPage.getElementById(it.key).setAttribute("value", it.value) }

        val resetForm = searchPage.getElementById("ctl00_ContentPlaceHolder1_Button4")
        val submit = searchPage.getElementById("ctl00_ContentPlaceHolder1_SearchButton")
        val resultsPage = submit.click<HtmlPage>()
        resultsPage.getByXPath<HtmlOrderedList>("/html/body/main/div/section/form/div[3]/ol").first()
            .getElementsByTagName("li").forEach {
                sectionList.add(extractSectionData(it))
            }

        webClient.close()
        return sectionList
    }
}

data class SectionDataDto(
    val subject: String,
    val catalogNumber: String,
    val sectionNumber: String,
    val classNumber: String?,
    val capacity: Int?,
    val title: String?,
    val units: Int?,
    val time: String?,
    val location: String?,
    val date: String?,
    val session: String?,
    val instructor: String?,
    val mode: String?
)

fun extractSectionData(sectionElement: DomElement): SectionDataDto {
    val sectionTableData = sectionElement.getElementsByTagName("td")
    val course = sectionElement.childElements.first()

    return SectionDataDto(
        course.asNormalizedText().split(' ')[0],
        course.asNormalizedText().split(' ')[1],
        course.nextSibling.asNormalizedText().split(' ')[1],
        sectionTableData[0].textContent.trim(),
        sectionTableData[1].textContent.trim().toIntOrNull(),
        sectionTableData[2].textContent.trim(),
        sectionTableData[3].textContent.trim().toIntOrNull(),
        sectionTableData[4].asNormalizedText().replace(Regex("\\s+"), " "),
        sectionTableData[5].textContent.trim(),
        sectionTableData[6].textContent.trim(),
        sectionTableData[7].textContent.trim(),
        sectionTableData[8].textContent.trim(),
        sectionTableData[9].textContent.trim()
    )
}