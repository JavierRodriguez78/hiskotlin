package com.javierrodriguez.hiskotlin.doctors.domain.dao

import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor

interface IDoctorDao {
    fun getDoctorById(id:Int):Doctor
}