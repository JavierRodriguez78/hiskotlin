package com.javierrodriguez.hiskotlin.application.infraestructure.serviceSwagger





import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo

import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
   open fun apiDocket():Docket=
         Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                 .apiInfo(getApiInfo())



   private fun getApiInfo(): ApiInfo {
        return ApiInfo(
                "HisKotlin",
                "App in kotlin and Spring Boot",
                "1.0.0",
                "Terms of Service",
               "xavi@geekshubs.com",
                "MIT",
                "xavi@geekshubs.com"
                 )

    }


}