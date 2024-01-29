package com.test.work.domain.comment.dto

data class UpdateCommentRequest(
    val userId : Long,
    val comment : String
)
