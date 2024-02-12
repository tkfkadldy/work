package com.test.one.domain.user.dto
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserUpdateRequest(
    @field:NotBlank(message = "닉네임은 필수입니다.")
    val name: String?,
    @field:NotBlank(message = "이메일은 필수입니다.")
    @field:Email(message = "이메일 형식이 아닙니다.")
    val email: String?
)
