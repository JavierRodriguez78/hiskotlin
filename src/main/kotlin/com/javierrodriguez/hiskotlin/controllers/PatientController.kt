package com.javierrodriguez.hiskotlin.controllers

import com.javierrodriguez.hiskotlin.domain.entities.Patient
import com.javierrodriguez.hiskotlin.domain.services.IPatientService
import org.apache.juli.logging.Log
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.GET
import java.util.*
import java.util.logging.Logger

@RestController
@RequestMapping("api/v1")
class PatientController {
    private var Logger = LogFactory.getLog("PatientController.class")

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

    @GetMapping("patients/{id}")
    fun getPatientByID(@PathVariable id:Int):ResponseEntity<Optional<Patient>>
    {
        Logger.warn("Captura" + id)
        val result:Optional<Patient> = patientService.getPatientByID(id)
        return ResponseEntity(result, HttpStatus.OK)
    }
}