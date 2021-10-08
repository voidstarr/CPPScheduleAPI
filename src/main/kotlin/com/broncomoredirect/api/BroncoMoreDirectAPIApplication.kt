package com.broncomoredirect.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BroncoMoreDirectAPIApplication

fun main(args: Array<String>) {
    runApplication<BroncoMoreDirectAPIApplication>(*args)
}

@RestController
@RequestMapping(path = ["/api/v1"])
class CPPScheduleController(var cppScheduleService: CPPScheduleService, var rmpService: RateMyProfessorsService) {

    @GetMapping("/sections/{subject}/{catalogNumber}/{term}", "/sections/{subject}/{catalogNumber}")
    fun searchSections(
        @PathVariable("subject") subject: String,
        @PathVariable("catalogNumber") catalogNumber: String,
        @PathVariable("term") term: String?
    ): ResponseEntity<List<SectionDataDto>> {
        return ResponseEntity.ok(
            cppScheduleService.getSections(
                buildSearchParams(
                    subject = ClassSubject.valueOf(subject.uppercase()),
                    catalogNumber = catalogNumber,
                    term = convertTerm(term)
                )
            )
        )
    }

    @GetMapping("/rating/professor/{professorLast}/{professorFirst}")
    fun getProfessorRating(
        @PathVariable("professorLast") professorLast: String,
        @PathVariable("professorFirst") professorFirst: String
    ): ResponseEntity<ProfessorRatingDto> {
        return ResponseEntity.ok(
            rmpService.getProfessorRating(professorLast, professorFirst)
        )
    }
}

