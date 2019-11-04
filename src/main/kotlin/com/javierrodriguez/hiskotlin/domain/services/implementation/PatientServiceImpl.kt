package com.javierrodriguez.hiskotlin.domain.services.implementation

import com.javierrodriguez.hiskotlin.domain.entities.Patient
import org.springframework.stereotype.Service
import com.javierrodriguez.hiskotlin.domain.services.IPatientService
@Service
class PatientServiceImpl  : IPatientService {
    override fun getPatients(): List<Patient> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}