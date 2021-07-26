package com.cs4080.cppscheduleapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class CPPScheduleAPIApplication

fun main(args: Array<String>) {
    runApplication<CPPScheduleAPIApplication>(*args)
}

@RestController
@RequestMapping(path = ["/api/v1"])
class CPPScheduleController(var service: CPPScheduleService) {

    @GetMapping("/sections/{subject}/{catalogNumber}/{term}", "/sections/{subject}/{catalogNumber}")
    fun searchSections(
        @PathVariable("subject") subject: String,
        @PathVariable("catalogNumber") catalogNumber: String,
        @PathVariable("term") term: String?
    ): ResponseEntity<List<SectionDataDto>> {
        return ResponseEntity.ok(
            service.getSections(
                buildSearchParams(
                    subject = ClassSubject.valueOf(subject.uppercase()),
                    catalogNumber = catalogNumber,
                    term = convertTerm(term)
                )
            )
        )
    }
}

