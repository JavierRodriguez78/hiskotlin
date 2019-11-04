package com.javierrodriguez.hiskotlin.domain.services

import com.javierrodriguez.hiskotlin.domain.entities.Patient

interface IPatientService {
    fun getPatients():List<Patient>
    fun addPatient(patient:Patient):Patient
}