package com.javierrodriguez.hiskotlin.doctors.domain.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.javierrodriguez.hiskotlin.Patients.domain.entities.Patient
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name="doctor")
data class Doctor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long=0,
        @Column(unique=true)
        @NotEmpty
        var collegiatenumber: Long?,
        var name: String?,
        var lastname: String?,
        var specialty: String?,
        @NotNull
        var created_at: LocalDateTime = LocalDateTime.now(),
        var update_at: LocalDateTime?,
        @OneToMany(mappedBy="doctor", cascade=arrayOf(CascadeType.ALL), fetch=FetchType.EAGER)
        @JsonManagedReference
        var patients : List<Patient> = emptyList()
        )
{
}