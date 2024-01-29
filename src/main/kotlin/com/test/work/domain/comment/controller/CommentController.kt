package com.test.work.domain.comment.controller

import com.test.work.domain.comment.dto.CommentResponse
import com.test.work.domain.comment.dto.CreateCommentRequest
import com.test.work.domain.comment.dto.UpdateCommentRequest
import com.test.work.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/works/{workId}/comments")
@RestController
class CommentController(
  private val commentService: CommentService
) {
    @GetMapping
    fun getAllCommentList(@PathVariable workId: Long): ResponseEntity<List<CommentResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getAllCommentList(workId))
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable workId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(workId, commentId, updateCommentRequest))
    }

    @PostMapping
    fun createComment(
        @PathVariable workId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(workId , createCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable workId: Long,
        @PathVariable commentId: Long
    ): ResponseEntity<Unit> {
        commentService.deleteComment(workId, commentId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}
