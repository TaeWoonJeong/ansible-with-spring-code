package com.jose.ansiblespring.model.redis

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("users")
class RedisUsers(
    @Id
    val id: String, //UUID
    val email: String,
    val name: String
)