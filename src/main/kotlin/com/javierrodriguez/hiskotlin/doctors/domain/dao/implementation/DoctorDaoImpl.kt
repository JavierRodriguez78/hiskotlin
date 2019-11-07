package com.javierrodriguez.hiskotlin.doctors.domain.dao.implementation

import com.javierrodriguez.hiskotlin.doctors.domain.dao.IDoctorDao
import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor
import org.apache.juli.logging.LogFactory
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.PersistenceContext
import javax.transaction.Transactional
import javax.persistence.EntityManager
import javax.persistence.NamedQuery
import javax.persistence.Query

@Transactional
@Repository
class DoctorDaoImpl: IDoctorDao {
    private var Logger = LogFactory.getLog("DoctorDaoImpl.class")

    @PersistenceContext
    private lateinit var entityManager:EntityManager
    private lateinit var sess:Session


    override fun getDoctorById(id:Int): Doctor {
      val result:Doctor = entityManager.find(Doctor::class.java, id)
        return result
    }



    override fun getDoctors():List<Doctor> {


      val result = entityManager.createNativeQuery("select * from doctors").resultList.toList()
        Logger.warn(result)
        return result as List<Doctor>

    }

    override fun addDoctor(doctor:Doctor) {entityManager.persist(doctor)}


}