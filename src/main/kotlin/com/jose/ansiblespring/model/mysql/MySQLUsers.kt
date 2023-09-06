package com.jose.ansiblespring.model.mysql

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class MySQLUsers(
    @Id
    var id: String, //UUID

    val email: String,

    val name: String
)