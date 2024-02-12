package com.test.one.domain.user.dto

import com.test.one.domain.user.model.User
import com.test.one.domain.user.model.UserType

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val authority: UserType
) {
    companion object {
        fun from(user: User) : UserResponse {
            return UserResponse(
                id = user.id !!,
                name = user.name,
                email = user.email,
                authority = user.authority
            )
        }
    }
}
