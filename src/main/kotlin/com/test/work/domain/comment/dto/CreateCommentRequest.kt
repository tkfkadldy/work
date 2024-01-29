package com.test.work.domain.comment.dto

import jakarta.persistence.Id

data class CreateCommentRequest(
    val userId: Long,
    val comment : String
)
