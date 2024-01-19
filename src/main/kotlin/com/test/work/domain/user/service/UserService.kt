package com.test.work.domain.user.service

import com.test.work.domain.user.dto.*

interface UserService {

    fun getUserProfileById(userId: Long): UserResponse

    fun signUp(signUpRequest: SignUpRequest): UserResponse

    fun userLogin(request: LoginRequest): LoginResponse

    fun userLoginOut(request: LoginRequest): LoginResponse

    fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse
}