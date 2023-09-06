package com.jose.ansiblespring.service

import com.jose.ansiblespring.model.mysql.MySQLUsers
import com.jose.ansiblespring.repository.mysql.UserMySQLRepository
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.TimeUnit


@Service
class DBService(private val stringRedisTemplate: StringRedisTemplate,
                private val userMySQLRepository: UserMySQLRepository
) {
    fun getRedis(): Map<String, String> {
        return stringRedisTemplate.keys("*").associateWith { key -> stringRedisTemplate.opsForValue().get(key)!! }
    }

    fun addRedis(email:String, name:String) {
        stringRedisTemplate.opsForValue().set(
            UUID.randomUUID().toString(), "$email $name", 600000, TimeUnit.MILLISECONDS
        )
    }

    fun getMySQL(): List<MySQLUsers> {
        return userMySQLRepository.findAll()
    }

    fun addMySQL(email: String, name: String) {
        userMySQLRepository.save(
            MySQLUsers(
                id = UUID.randomUUID().toString(),
                email = email,
                name = name
            )
        )
    }
}