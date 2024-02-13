package com.test.one.domain.user.model

import com.test.one.domain.common.BaseTimeEntity
import com.test.one.domain.user.dto.UserUpdateRequest
import com.test.one.domain.user.dto.UserResponse
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "user")
class User(
    @Column(name = "name")
    var name: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "email")
    var email: String,

    @Enumerated(EnumType.STRING)
    val authority: UserType = UserType.USER

) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateUser(userUpdateRequest: UserUpdateRequest) {
        name = userUpdateRequest.name ?: name
        email = userUpdateRequest.email ?: email
    }
}
/*
fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        name = name,
        email = email,
        authority = authority
    )
}*/
