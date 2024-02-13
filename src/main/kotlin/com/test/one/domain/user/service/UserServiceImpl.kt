package com.test.one.domain.user.service

import com.test.one.domain.exception.InvalidCredentialException
import com.test.one.domain.exception.ModelNotFoundException
import com.test.one.domain.exception.UniqueAttributeValueAlreadyExistException
import com.test.one.domain.user.dto.*
import com.test.one.domain.user.model.User
import com.test.one.domain.user.repository.UserRepository
import com.test.one.infra.security.jwt.JwtPlugin
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) : UserService {

    override fun joinUser(userRegisterRequest: UserRegisterRequest): UserResponse {
        if(userRepository.existsByEmail(userRegisterRequest.email))
            throw UniqueAttributeValueAlreadyExistException("email", userRegisterRequest.email)
        if(userRegisterRequest.passwordConfirm != userRegisterRequest.password) throw InvalidCredentialException()
        val user = userRepository.save(userRegisterRequest.to(passwordEncoder))
        return UserResponse.from(user)
    }

    override fun loginUser(userLoginRequest: UserLoginRequest) : LoginResponse {
        val user = userRepository.findByEmail(userLoginRequest.email) ?: throw ModelNotFoundException("User", null)
        if(!passwordEncoder.matches(userLoginRequest.password, user.password)) throw InvalidCredentialException()
        return LoginResponse(user.email, user.authority,
            jwtPlugin.generateToken(user.id.toString(), user.email, user.authority.name)
        )
    }

    override fun updateUser(userId: Long, userUpdateRequest: UserUpdateRequest): UserResponse {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)

        if(userRepository.existsByEmail(userUpdateRequest.email ?: user.email) && user.email != userUpdateRequest.email)
            throw UniqueAttributeValueAlreadyExistException("email" , userUpdateRequest.email!!)
        user.updateUser(userUpdateRequest)
        return UserResponse.from(userRepository.save(user))
    }
}