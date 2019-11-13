package com.javierrodriguez.hiskotlin

import com.javierrodriguez.hiskotlin.application.infraestructure.security.JWTAuthorizationFilter
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

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
                    .antMatcher("/api/**").authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .addFilterBefore(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
                  /*  .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/auth").anonymous()
                    .antMatchers("/api/v1/patients/").permitAll()
                    .anyRequest().authenticated()*/

        }
    }
}