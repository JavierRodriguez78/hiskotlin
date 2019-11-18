package com.javierrodriguez.hiskotlin.controllers

import com.javierrodriguez.hiskotlin.HiskotlinApplication
import com.javierrodriguez.hiskotlin.patients.domain.entities.Patient
import com.javierrodriguez.hiskotlin.patients.infraestructure.controllers.PatientController
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import javax.swing.Spring

@RunWith(SpringRunner::class)
@WebMvcTest(PatientController::class)
class PatientControllersTest {

    @Autowired
    private lateinit var mockMvc: MockMvc





    @Test
    fun returnForbiddenIsNotAuthenticated():Unit {
        mockMvc.perform(get("/patients")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk)

    }
}