package com.test.one.domain.user.controller

import com.test.one.domain.user.dto.*
import com.test.one.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService
){
    @PostMapping("/login")
    fun loginUser(
        @RequestBody userLoginRequest: UserLoginRequest
    ) : ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.loginUser(userLoginRequest))
    }

    @PostMapping("/join")
    fun joinUser(
        @RequestBody userRegisterRequest : UserRegisterRequest
    ) : ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.joinUser(userRegisterRequest))
    }

    @PutMapping("/{userId}")
    fun updateUser(
        @PathVariable userId: Long,
        @RequestBody userUpdateRequest : UserUpdateRequest
    ) : ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updateUser(userId,userUpdateRequest))
    }

}