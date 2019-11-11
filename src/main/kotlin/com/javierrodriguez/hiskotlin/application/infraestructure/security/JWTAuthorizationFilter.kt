package com.javierrodriguez.hiskotlin.application.infraestructure.security

import org.apache.juli.logging.LogFactory
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter:OncePerRequestFilter(){
    private var Logger = LogFactory.getLog("JWTAuthorizationFilter.class")

    var HEADER:String="Authorization"
    var PREFIX:String ="Bearer"

    lateinit var properties:Properties

    lateinit var SECRET:String;

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        if(this.existJWT(request,response)){
            Logger.warn("Exsite Header")
        }


         }


    fun existJWT(req: HttpServletRequest, res:HttpServletResponse):Boolean
    {
        var authHeader:String = req.getHeader(HEADER)
        if(authHeader==null) return false
        return true
    }
}