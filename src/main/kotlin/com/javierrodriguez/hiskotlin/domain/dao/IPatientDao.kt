package com.javierrodriguez.hiskotlin.domain.dao

import com.javierrodriguez.hiskotlin.domain.entities.Patient
import org.springframework.data.repository.CrudRepository

interface IPatientDao: CrudRepository<Patient, Int> {
}