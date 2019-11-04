package com.javierrodriguez.hiskotlin.controllers

import com.javierrodriguez.hiskotlin.domain.entities.Patient
import com.javierrodriguez.hiskotlin.domain.services.IPatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping("api/v1")
class PatientController {

    @Autowired
    private lateinit var patientService:IPatientService

    @RequestMapping("hello")
    fun HelloWorld(): ResponseEntity<Unit> {
     return ResponseEntity<Unit>(HttpStatus.OK);
    }

    @RequestMapping("patients","GET","application/json")
    fun getPatients():ResponseEntity<List<Patient>> = ResponseEntity(patientService.getPatients(), HttpStatus.OK)

    @PostMapping("patients")
    fun addPatient(@RequestBody patient:Patient):ResponseEntity<Patient>{
       val result:Patient = patientService.addPatient(patient)
        return ResponseEntity(result, HttpStatus.OK)
    }
}