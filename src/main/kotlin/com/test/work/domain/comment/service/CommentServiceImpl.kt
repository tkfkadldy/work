package com.test.work.domain.comment.service

import com.test.work.domain.comment.dto.CommentResponse
import com.test.work.domain.comment.dto.CreateCommentRequest
import com.test.work.domain.comment.dto.UpdateCommentRequest
import com.test.work.domain.comment.exception.CommentNotFoundException
import com.test.work.domain.comment.model.Comment
import com.test.work.domain.comment.model.toResponse
import com.test.work.domain.comment.repository.CommentRepository
import com.test.work.domain.user.repository.UserRepository
import com.test.work.domain.work.repository.WorkRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl (
    private val commentRepository: CommentRepository,
    private val workRepository: WorkRepository,
    private val userRepository: UserRepository
): CommentService {
    override fun getAllCommentList(workId: Long): List<CommentResponse> {
        TODO()
    }

    @Transactional
    override fun createComment(workId: Long, request: CreateCommentRequest): CommentResponse {
        TODO()
    }

    @Transactional
    override fun updateComment(workId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO()
    }

    @Transactional
    override fun deleteComment(workId: Long, commentId: Long) {
        TODO()
        }
}