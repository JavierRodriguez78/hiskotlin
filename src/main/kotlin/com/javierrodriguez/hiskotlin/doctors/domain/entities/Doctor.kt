package com.javierrodriguez.hiskotlin.doctors.domain.entities

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="doctors")
data class Doctor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int?,
        @Column(unique=true)
        var collegiatenumber: Long?,
        var name: String?,
        var lastname: String?,
        var specialty: String?,
        @NotNull
        var created_at: LocalDateTime = LocalDateTime.now(),
        var update_at: LocalDateTime?) {
}