package com.javierrodriguez.hiskotlin.application.infraestructure.controllers

import com.javierrodriguez.hiskotlin.application.domain.dao.IUserDao
import com.javierrodriguez.hiskotlin.application.domain.entities.User
import com.javierrodriguez.hiskotlin.application.services.IServiceAuth
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
class AuthController {
    private var Logger = LogFactory.getLog("AuthController.class")

    @Autowired
    lateinit var serviceJWT:IServiceAuth
    @Autowired
    lateinit var userDao: IUserDao

   @PostMapping("/auth")
    fun login(@RequestBody user:User, request:HttpServletRequest): ResponseEntity<Any>
    {
        var result = userDao.findByUsername(user.username!!)
        if(!result.isPresent) return ResponseEntity("Datos Incorrecto",HttpStatus.BAD_REQUEST)
        if(!user.password.equals(result.get().password)) return ResponseEntity("Datos Incorrecto", HttpStatus.BAD_REQUEST)
        Logger.warn(result)
        var token:String = serviceJWT.getJWT(result.get().username as String, request)
        return ResponseEntity(token, HttpStatus.OK)

    }
}