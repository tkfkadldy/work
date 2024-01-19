package com.test.work.domain.comment.service

import com.test.work.domain.comment.dto.CommentResponse
import com.test.work.domain.comment.dto.CreateCommentRequest
import com.test.work.domain.comment.dto.UpdateCommentRequest

interface CommentService {
    fun getAllCommentList(workId: Long): List<CommentResponse>

    fun createComment(workId: Long, request: CreateCommentRequest): CommentResponse

    fun updateComment(workId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(workId: Long, commentId: Long)
}