package com.test.one.domain.user.repository

import com.test.one.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long> {
    fun existsByEmail(email: String): Boolean

    fun findByEmail(email: String): User?

    fun findUserById(id :Long) : User?
}