package com.javierrodriguez.hiskotlin.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class PatientController {

    @RequestMapping("hello")
    fun HelloWorld(): ResponseEntity<Unit> {
     return ResponseEntity<Unit>(HttpStatus.OK);
    }
}