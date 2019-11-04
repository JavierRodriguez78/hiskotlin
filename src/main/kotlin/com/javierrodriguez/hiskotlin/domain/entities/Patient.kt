package com.javierrodriguez.hiskotlin.domain.entities

import com.sun.istack.NotNull
import org.hibernate.annotations.Columns
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Patient (
        @Id
        @GeneratedValue
        var id: Int?,
        var sip: Long?,
        var name: String?,
        var lastname: String?,
        @NotNull
        var created_at: LocalDateTime?,
        var update_at: LocalDateTime?
        )