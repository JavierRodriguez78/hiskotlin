package com.javierrodriguez.hiskotlin.application.services

import javax.servlet.http.HttpServletRequest

interface IServiceUser {
    fun getJWT(username:String, request:HttpServletRequest ):String
}