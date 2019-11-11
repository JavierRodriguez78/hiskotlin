package com.javierrodriguez.hiskotlin

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootApplication
class HiskotlinApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<HiskotlinApplication>(*args)
        }
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig:WebSecurityConfigurerAdapter()
    {
        override fun configure(httpSecurity:HttpSecurity){

            httpSecurity
                    .cors()
                    .and()
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/api/v1/auth/").permitAll()
                    .anyRequest().authenticated()

        }
    }
}