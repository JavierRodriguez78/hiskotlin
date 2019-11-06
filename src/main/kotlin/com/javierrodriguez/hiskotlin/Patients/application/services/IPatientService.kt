package com.javierrodriguez.hiskotlin.Patients.application.services

import com.javierrodriguez.hiskotlin.Patients.domain.entities.Patient
import java.util.*

interface IPatientService {
    fun getPatients():List<Patient>
    fun addPatient(patient:Patient):Patient
    fun getPatientByID(id:Int): Optional<Patient>
    fun getPatientBySip(sip:Long): Optional<Patient>
    fun deletePatientBySip(Sip:Long):Boolean
}