package com.javierrodriguez.hiskotlin.application.services

import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

@Service
interface IServiceUser {
    fun getJWT(username:String, request:HttpServletRequest ):String
}