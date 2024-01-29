package com.test.work.domain.user.service

import com.test.work.domain.user.dto.*
import com.test.work.domain.user.excepion.UserNotFoundException
import com.test.work.domain.user.model.toResponse
import com.test.work.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getUserProfileById(userId: Long): UserResponse {
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException("User", userId)
        return user.toResponse()
    }

    override fun signUp(signUpRequest: SignUpRequest): UserResponse {
        TODO()
    }


    override fun userLogin(request: LoginRequest): LoginResponse {
        TODO()
    }

    override fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse {
        TODO()
    }
}