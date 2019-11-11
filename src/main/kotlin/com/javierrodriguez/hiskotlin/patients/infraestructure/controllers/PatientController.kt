package com.javierrodriguez.hiskotlin.patients.infraestructure.controllers

import com.javierrodriguez.hiskotlin.patients.domain.entities.Patient
import com.javierrodriguez.hiskotlin.patients.application.services.IPatientService
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/patients")
class PatientController {
    private var Logger = LogFactory.getLog("PatientController.class")

    @Autowired
    private lateinit var patientService:IPatientService

    @RequestMapping("hello")
    fun HelloWorld(): ResponseEntity<Unit> {
     return ResponseEntity<Unit>(HttpStatus.OK);
    }

    @RequestMapping("/","GET","application/json")
    fun getPatients():ResponseEntity<List<Patient>> = ResponseEntity(patientService.getPatients(), HttpStatus.OK)

    @PostMapping("/")
    fun addPatient(@RequestBody patient:Patient):ResponseEntity<Patient>{
       val result: Patient = patientService.addPatient(patient)
          return when(result) {
              null ->  ResponseEntity(result, HttpStatus.BAD_REQUEST)
              else -> ResponseEntity(result, HttpStatus.CREATED)
        }
    }

    @GetMapping("/{id}")
    fun getPatientByID(@PathVariable id:Int): ResponseEntity<Patient>
    {
        Logger.warn("Captura" + id)
        val result: Optional<Patient> = patientService.getPatientByID(id)

        return result.map {res-> ResponseEntity(res, HttpStatus.OK)}
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))

    }
    @GetMapping("/sip/{sip}")
    fun getPatientBySip(@PathVariable sip:Long):ResponseEntity<Patient>
    {
        Logger.warn("Captura" + sip)
        val result:Optional<Patient> = patientService.getPatientBySip(sip)
        return result.map { res-> ResponseEntity(res, HttpStatus.OK)}
                .orElse(ResponseEntity(HttpStatus.NO_CONTENT))
    }

    @DeleteMapping("/sip/{sip}")
    fun deletePatientBySip(@PathVariable sip:Long):ResponseEntity<Boolean>
    {
        Logger.warn("Borrado ->"+ sip)
        val result:Boolean = patientService.deletePatientBySip(sip)
       if (result) return ResponseEntity(result, HttpStatus.OK)
        return ResponseEntity(false, HttpStatus.NOT_FOUND)
    }
}