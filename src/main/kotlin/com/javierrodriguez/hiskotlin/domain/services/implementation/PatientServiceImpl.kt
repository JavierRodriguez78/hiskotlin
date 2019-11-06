package com.javierrodriguez.hiskotlin.domain.services.implementation

import com.javierrodriguez.hiskotlin.domain.dao.IPatientDao
import com.javierrodriguez.hiskotlin.domain.entities.Patient
import org.springframework.stereotype.Service
import com.javierrodriguez.hiskotlin.domain.services.IPatientService
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@Service
class PatientServiceImpl  : IPatientService {

    @Autowired
    private lateinit var  patientDao: IPatientDao

    private var Logger = LogFactory.getLog("PatientServiceImpl.class")

    override fun addPatient(patient: Patient):Patient = patientDao.save(patient)



    override fun getPatients(): List<Patient> = patientDao.findAll() as List<Patient>

    override fun getPatientByID(id: Int): Optional<Patient> = patientDao.findById(id)

    override fun getPatientBySip(sip: Long): Optional<Patient> = patientDao.findBySip(sip)
}