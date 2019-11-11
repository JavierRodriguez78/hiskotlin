package com.javierrodriguez.hiskotlin.application.domain.dao

import com.javierrodriguez.hiskotlin.application.domain.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface IUserDao: CrudRepository<User, Int> {
     fun findByUsername(username:String) : Optional<User>
}