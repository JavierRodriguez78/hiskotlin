package com.javierrodriguez.hiskotlin.application.domain.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        var username: String?,
        var password: String?,
        @NotNull
        var created_at: LocalDateTime = LocalDateTime.now(),
        var update_at: LocalDateTime?
) {
}