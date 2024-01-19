package com.test.work.domain.user.model

import com.test.work.domain.user.dto.UserResponse
import jakarta.persistence.*

@Entity
@Table(name = "work_user")
class User(

    @Column(name = "name", nullable = false)
    val name:String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        name = name,
        email = email,
        password = password
    )
}