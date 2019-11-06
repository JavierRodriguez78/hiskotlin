package com.javierrodriguez.hiskotlin.domain.services

import com.javierrodriguez.hiskotlin.domain.entities.Patient
import java.util.*

interface IPatientService {
    fun getPatients():List<Patient>
    fun addPatient(patient:Patient):Patient
    fun getPatientByID(id:Int): Optional<Patient>
    fun getPatientBySip(sip:Long): Optional<Patient>
    fun deletePatientBySip(Sip:Long):Boolean
}