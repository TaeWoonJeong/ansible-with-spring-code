package com.jose.ansiblespring.repository.mysql

import com.jose.ansiblespring.model.mysql.MySQLUsers
import org.springframework.data.jpa.repository.JpaRepository

interface UserMySQLRepository: JpaRepository<MySQLUsers, String> {
}