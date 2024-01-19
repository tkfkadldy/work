package com.test.work.domain.comment.exception

data class CommentNotFoundException(val comment: String, val commentId: Long?) :
    RuntimeException("$comment not found with given id: $commentId")


