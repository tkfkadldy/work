package com.test.work.domain.comment.controller

import com.test.work.domain.comment.dto.CommentResponse
import com.test.work.domain.comment.dto.CreateCommentRequest
import com.test.work.domain.comment.dto.UpdateCommentRequest
import com.test.work.domain.comment.exception.CommentNotFoundException
import com.test.work.domain.comment.exception.dto.ErrorResponse
import com.test.work.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/works/{workId}/comments")
@RestController
class CommentController{
    @GetMapping
    fun getCommentList(@PathVariable workId: Long): ResponseEntity<List<CommentResponse>> {
        TODO()
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable workId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        TODO()
    }

    @PostMapping
    fun createComment(
        @PathVariable workId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        TODO()
    }


    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable workId: Long,
        @PathVariable commentId: Long
    ): ResponseEntity<Unit> {
        TODO()

    }

}