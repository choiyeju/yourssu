package com.example.yourssu2

import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication

@EnableJpaAuditing
@SpringBootApplication
open class Yourssu2Application{
    companion object Yourssu2Application2 {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Yourssu2Application::class.java, *args)
        }
    }
}
