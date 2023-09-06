package com.jose.ansiblespring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.UUID

@RestController
class UtilController {
    val uuid: String = UUID.randomUUID().toString()
    @GetMapping("/health")
    fun health() : String{
        return "OK"
    }

    @GetMapping("/info")
    fun info() : String {
        return "현재 시간은 "+ LocalDateTime.now() + "이고, uuid 값 : "+uuid
    }
}