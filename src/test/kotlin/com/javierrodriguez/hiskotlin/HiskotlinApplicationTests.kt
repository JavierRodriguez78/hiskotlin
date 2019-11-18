package com.javierrodriguez.hiskotlin

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(HiskotlinApplication::class), webEnvironment = WebEnvironment.RANDOM_PORT)
class HiskotlinApplicationTests {

    @Test
    fun contextLoads() {
    }

}
