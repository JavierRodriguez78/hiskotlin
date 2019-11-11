package com.javierrodriguez.hiskotlin.application.controllers

import com.javierrodriguez.hiskotlin.application.domain.dao.IUserDao
import com.javierrodriguez.hiskotlin.application.domain.entities.User
import org.apache.juli.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("api/v1/auth")
class AuthController {
    private var Logger = LogFactory.getLog("AuthController.class")

    @Autowired
    lateinit var userDao: IUserDao

   @PostMapping("/")
    fun login(@RequestBody user:User, request:HttpServletRequest): ResponseEntity<Unit>
    {
        var result = userDao.findByUsername(user.username!!)
        Logger.warn(result)
        return ResponseEntity(HttpStatus.OK)

    }
}