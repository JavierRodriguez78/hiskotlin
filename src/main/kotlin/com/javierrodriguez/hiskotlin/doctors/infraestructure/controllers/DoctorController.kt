package com.javierrodriguez.hiskotlin.doctors.infraestructure.controllers

import com.javierrodriguez.hiskotlin.Patients.domain.entities.Patient
import com.javierrodriguez.hiskotlin.doctors.application.services.IDoctorService
import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("api/v1/doctor")
class DoctorController {
    private var Logger = LogFactory.getLog("DoctorController.class")

    @Autowired
    private lateinit var doctorService: IDoctorService

    @GetMapping("/{id}")
    fun getDoctorByID(@PathVariable id:Int): ResponseEntity<Doctor>
    {
        Logger.warn("Captura" + id)
        val result: Doctor = doctorService.getDoctorByID(id)

        return ResponseEntity(result, HttpStatus.OK)


    }
    @GetMapping("/")
    fun getDoctors(): ResponseEntity<List<Doctor>>
    {

         var result:List<Doctor> = doctorService.getDoctors();

        return ResponseEntity(result, HttpStatus.OK)


    }

    @PostMapping("/")
    fun addDoctor(@RequestBody doctor:Doctor):ResponseEntity<Unit>{
        try {
            Logger.warn("Doctor creado")
            doctorService.addDoctor(doctor)
            return ResponseEntity(HttpStatus.CREATED)
        }catch(e:Exception){
            Logger.error(e.message)
            return ResponseEntity(HttpStatus.BAD_GATEWAY)
        }
    }

}