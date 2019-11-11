package com.javierrodriguez.hiskotlin.patients.domain.dao

import com.javierrodriguez.hiskotlin.patients.domain.entities.Patient
import org.springframework.data.jpa.repository.JpaRepository

import java.util.*

interface IPatientDao: JpaRepository<Patient, Int> {
    public fun findBySip(sip:Long): Optional<Patient>
    public fun deleteBySip(sip:Long):Int
}