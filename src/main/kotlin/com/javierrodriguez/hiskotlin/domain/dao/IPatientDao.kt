package com.javierrodriguez.hiskotlin.domain.dao

import com.javierrodriguez.hiskotlin.domain.entities.Patient
import org.springframework.data.repository.CrudRepository
import java.util.*

interface IPatientDao: CrudRepository<Patient, Int> {
    public fun findBySip(sip:Long): Optional<Patient>
}