package com.test.work.domain.user.service

import com.test.work.domain.user.dto.*
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
        TODO()
    }

    override fun signUp(request: SignUpRequest): UserResponse {
        // TODO: Email이 중복되는지 확인, 중복된다면 throw IllegalStateException
        // TODO: request를 User로 변환 후 DB에 저장, 비밀번호는 저장시 암호화
        // TODO: 가입시 이메일 인증 날리기
        TODO("Not yet implemented")
    }


    override fun userLogin(request: LoginRequest): LoginResponse {
        TODO()
    }



    override fun userLoginOut(request: LoginRequest): LoginResponse {
    // TODO: 로그아웃
    TODO("Not yet implemented")
    }

    override fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse {
    // TODO: 만약 userId에 해당하는 User가 없다면 throw ModelNotFoundException
    // TODO: DB에서 userId에 해당하는 User를 가져와서 updateUserProfileRequest로 업데이트 후 DB에 저장, 결과를 UserResponse로 변환 후 반환
    TODO("Not yet implemented")
    }
}