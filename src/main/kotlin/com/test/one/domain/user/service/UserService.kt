package com.test.one.domain.user.service

import com.test.one.domain.user.dto.*

interface UserService {
    //로그인
    fun loginUser(userLoginRequest: UserLoginRequest) : LoginResponse

    //회원가입
    fun joinUser(userRegisterRequest: UserRegisterRequest) : UserResponse

    //수정하기
    fun updateUser(userId: Long, userUpdateRequest : UserUpdateRequest) : UserResponse

}