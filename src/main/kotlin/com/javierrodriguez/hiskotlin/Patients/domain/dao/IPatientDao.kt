package com.javierrodriguez.hiskotlin.Patients.domain.dao

import com.javierrodriguez.hiskotlin.Patients.domain.entities.Patient
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.data.repository.CrudRepository
import java.util.*

interface IPatientDao: JpaRepository<Patient, Int> {
    public fun findBySip(sip:Long): Optional<Patient>
    public fun deleteBySip(sip:Long):Int
}