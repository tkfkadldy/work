package com.test.work

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class WorkApplication

fun main(args: Array<String>) {
    runApplication<WorkApplication>(*args)
}