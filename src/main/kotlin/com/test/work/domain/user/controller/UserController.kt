package com.test.work.domain.user.controller

import com.test.work.domain.user.dto.*
import com.test.work.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users/{userId}")
    fun getUserProfile(@PathVariable userId: Long): ResponseEntity<UserResponse> {
        TODO()
        /*return ResponseEntity
            .status(HttpStatus.OK)
            .body(UserService.getUserProfileById(userId))*/
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<UserResponse> {
        TODO()
    }

    @PostMapping("/login")
    fun signIn(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.userLogin(loginRequest))
    }

    @PostMapping("/logout")
    fun signOut(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
       TODO()
    }


    @PutMapping("/users/{userId}/profile")
    fun updateUserProfile(@PathVariable userId: Long,
                          @RequestBody updateUserProfileRequest: UpdateUserProfileRequest
    ): ResponseEntity<UserResponse> {
        TODO()
    }
}