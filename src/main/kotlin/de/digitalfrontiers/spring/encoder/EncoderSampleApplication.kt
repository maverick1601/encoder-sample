package de.digitalfrontiers.spring.encoder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class EncoderSampleApplication

fun main(args: Array<String>) {
    runApplication<EncoderSampleApplication>(*args)
}
