package com.javierrodriguez.hiskotlin.Patients.domain.entities

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="patients")
data class Patient(
        @Id
        @GeneratedValue
        var id: Int?,
        var sip: Long?,
        var name: String?,
        var lastname: String?,
        @NotNull
        var created_at: LocalDateTime =LocalDateTime.now(),
        var update_at: LocalDateTime?
        )