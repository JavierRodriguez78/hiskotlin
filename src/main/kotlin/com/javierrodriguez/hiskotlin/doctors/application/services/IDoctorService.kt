package com.javierrodriguez.hiskotlin.doctors.application.services

import com.javierrodriguez.hiskotlin.Patients.domain.entities.Patient
import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor


interface IDoctorService {
    fun getDoctorByID(id:Int): Doctor
    fun getDoctors():List<Doctor>
    fun addDoctor(doctor:Doctor)
}