package com.javierrodriguez.hiskotlin.domain.services.implementation

import com.javierrodriguez.hiskotlin.domain.dao.IPatientDao
import com.javierrodriguez.hiskotlin.domain.entities.Patient
import org.springframework.stereotype.Service
import com.javierrodriguez.hiskotlin.domain.services.IPatientService
import org.springframework.beans.factory.annotation.Autowired

@Service
class PatientServiceImpl  : IPatientService {

    @Autowired
    private lateinit var  patientDao: IPatientDao

    override fun getPatients(): List<Patient> = patientDao.findAll() as List<Patient>


}