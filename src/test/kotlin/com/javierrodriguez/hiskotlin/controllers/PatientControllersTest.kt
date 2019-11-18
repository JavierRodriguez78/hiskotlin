package com.javierrodriguez.hiskotlin.controllers

import com.javierrodriguez.hiskotlin.HiskotlinApplication
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(HiskotlinApplication::class), webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PatientControllersTest {
}