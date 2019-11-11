package com.javierrodriguez.hiskotlin.application.services.implementation

import com.javierrodriguez.hiskotlin.application.services.IServiceUser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

class ServiceUserImpl: IServiceUser {

    @Value("${secretkey}")
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
                .setExpiration(Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.toByteArray()).compact()

        return token
    }
}