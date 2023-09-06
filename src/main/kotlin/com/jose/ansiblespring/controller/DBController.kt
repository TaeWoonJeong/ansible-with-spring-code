package com.jose.ansiblespring.controller

import com.jose.ansiblespring.model.mysql.MySQLUsers
import com.jose.ansiblespring.request.AddUserRequest
import com.jose.ansiblespring.service.DBService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DBController(private val dbService: DBService) {
    @GetMapping("/redis")
    fun getRedis(): Map<String, String> {
        return dbService.getRedis()
    }

    @PostMapping("/redis")
    fun addRedis(@RequestBody addUserRequest: AddUserRequest): String {
        dbService.addRedis(addUserRequest.email, addUserRequest.name)
        return "redis에 저장 완료"
    }

    @GetMapping("/mysql")
    fun getMySQL(): List<MySQLUsers> {
        return dbService.getMySQL()
    }

    @PostMapping("/mysql")
    fun addMySQL(@RequestBody addUserRequest: AddUserRequest): String {
        dbService.addMySQL(addUserRequest.email, addUserRequest.name)
        return "mysql에 저장 완료"
    }
}