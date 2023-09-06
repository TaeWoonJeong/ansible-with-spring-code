package com.jose.ansiblespring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnsibleSpringApplication

fun main(args: Array<String>) {
    runApplication<AnsibleSpringApplication>(*args)
}
