package com.javierrodriguez.hiskotlin.doctors.application.services.implementation

import com.javierrodriguez.hiskotlin.doctors.application.services.IDoctorService
import com.javierrodriguez.hiskotlin.doctors.domain.dao.IDoctorDao
import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DoctorServiceImpl: IDoctorService {
    @Autowired
    private lateinit var doctorDao: IDoctorDao
    override fun getDoctorByID(id: Int): Doctor = doctorDao.getDoctorById(id)

}