package com.test.one.domain.user.dto

import com.test.one.domain.user.model.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length
import org.springframework.security.crypto.password.PasswordEncoder

data class UserRegisterRequest(

    @field:NotBlank(message = "닉네임은 필수입니다.")
    @field:Length(min = 8, max = 15, message = "아이디는 3자 이상, 15자 이하여야합니다.")
    @field:Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{3,15}\$",
        message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 사용하세요.")
    val name: String,
    @field:NotBlank(message = "이메일은 필수입니다.")
    @field:Email(message = "이메일 형식이 아닙니다.")
    val email: String,
    val address: String,
    @field:Length(min = 8, max = 15, message = "비밀번호는 4자 이상, 15자 이하여야합니다.")
    @field:Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{4,15}\$",
        message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 사용하세요.")
    val password: String,
    val passwordConfirm: String,
)
{
    fun to(passwordEncoder: PasswordEncoder): User
    {
        return User(
            name = name,
            email = email,
            password = passwordEncoder.encode(password)
        )
    }
}
