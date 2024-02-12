package com.test.one.domain.user.dto

import com.test.one.domain.user.model.UserType

data class LoginResponse(
    val email: String,
    val type: UserType,
    val token: String
)