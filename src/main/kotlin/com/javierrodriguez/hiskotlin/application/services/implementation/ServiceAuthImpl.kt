package com.javierrodriguez.hiskotlin.application.services.implementation

import com.javierrodriguez.hiskotlin.application.services.IServiceAuth
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

@Service
class ServiceAuthImpl() : IServiceAuth {


    lateinit var  secretKey:String

    override fun getJWT(username: String, request: HttpServletRequest): String {



        var grantedAuthorities:List<GrantedAuthority> = commaSeparatedStringToAuthorityList("ROLE_USER")

        var  token:String = Jwts
                .builder()
                .claim("ip", request.getRemoteAddr())
                .setId("Creditas")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + 600000000))
                .signWith(SignatureAlgorithm.HS512, "bragasdeesparto".toByteArray()).compact()

        return "Bearer "+ token
    }
}