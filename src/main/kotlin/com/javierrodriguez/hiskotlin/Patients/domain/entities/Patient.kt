package com.javierrodriguez.hiskotlin.Patients.domain.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.javierrodriguez.hiskotlin.doctors.domain.entities.Doctor
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name="patients")
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        var sip: Long?,
        var name: String?,
        var lastname: String?,
        @NotNull
        var created_at: LocalDateTime =LocalDateTime.now(),
        var update_at: LocalDateTime?,
        @ManyToOne(cascade = arrayOf(CascadeType.ALL),fetch= FetchType.EAGER)
        @JoinColumn(name="doctor_id")
        @JsonBackReference
        var doctor: Doctor?=null
        )