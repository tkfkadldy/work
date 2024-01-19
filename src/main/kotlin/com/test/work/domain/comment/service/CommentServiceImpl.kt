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
        val work = workRepository.findByIdOrNull(workId) ?: throw CommentNotFoundException("Work", workId)
        return work.comment.map { it.toResponse() }
    }

    @Transactional
    override fun createComment(workId: Long, request: CreateCommentRequest): CommentResponse {
        TODO()
        /*val work = workRepository.findByIdOrNull(workId) ?: throw CommentNotFoundException("Work", workId)
        val user = userRepository.findByIdOrNull(request.userId) ?: throw CommentNotFoundException("User", request.userId)
        val comment = Comment(
            comment = request.comment,
            work = work,
            user = user
        )
        work.createComment(comment)
        workRepository.save(work)
        return comment.toResponse()*/
    }

    @Transactional
    override fun updateComment(workId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO()
        /*val comment = commentRepository.findByWorkIdAndId(workId, commentId)
            ?: throw CommentNotFoundException("Comment", commentId)

        val (comment) = request
        comment.comment = comment
        return commentRepository.save(comment).toResponse()*/
    }

    @Transactional
    override fun deleteComment(workId: Long, commentId: Long) {
        TODO()
        /*val work = workRepository.findByIdOrNull(workId) ?: throw CommentNotFoundException("Work", workId)
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw CommentNotFoundException("Comment", commentId)

        work.deleteComment(comment)
        workRepository.save(work)*/
    }
}