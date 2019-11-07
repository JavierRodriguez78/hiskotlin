package com.javierrodriguez.hiskotlin.doctors.domain.dao.implementation

import com.javierrodriguez.hiskotlin.doctors.domain.dao.IDoctorDao
import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor
import org.springframework.stereotype.Repository
import javax.persistence.PersistenceContext
import javax.transaction.Transactional
import javax.persistence.EntityManager

@Transactional
@Repository
class DoctorDaoImpl: IDoctorDao {

    @PersistenceContext
    private lateinit var entityManager:EntityManager


    override fun getDoctorById(id:Int): Doctor {
      val result:Doctor = entityManager.find(Doctor::class.java, id)
        return result
    }
}