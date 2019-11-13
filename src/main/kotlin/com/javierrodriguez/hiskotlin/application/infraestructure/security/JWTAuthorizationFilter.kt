package com.javierrodriguez.hiskotlin.application.infraestructure.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.apache.juli.logging.LogFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import java.util.stream.Collectors
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
            var claims:Claims = this.validateJWT(request)
            Logger.warn(claims)
            if(claims.get("authorities")!=null){
                this.setUpSpringAuthentication(claims)
            }else{
                SecurityContextHolder.clearContext()
            }

        }
        filterChain.doFilter(request, response)
        Logger.warn("He entrado por la puerta grande");

      }


    fun setUpSpringAuthentication(claims:Claims):Unit{
        var authorities:List<String> = claims.get("authorities") as List<String>
        var auth: UsernamePasswordAuthenticationToken =
                UsernamePasswordAuthenticationToken(claims.subject,
                        null,
                        authorities.stream().map(::SimpleGrantedAuthority)
                                .collect(Collectors.toList<SimpleGrantedAuthority>()))

                SecurityContextHolder.getContext().authentication=auth
    }

    fun validateJWT(req:HttpServletRequest): Claims {
        var jwtToken:String =  req.getHeader(HEADER).replace(PREFIX," ")
        return Jwts.parser().setSigningKey("bragasdeesparto".toByteArray())
                .parseClaimsJws(jwtToken).body
        }

    fun existJWT(req: HttpServletRequest, res:HttpServletResponse):Boolean
    {
        var authHeader:String = req.getHeader(HEADER)
        if(authHeader==null) return false
        Logger.warn(authHeader.contains(PREFIX))
       //S if(!authHeader.contains(PREFIX)) return false
        return true
    }
}