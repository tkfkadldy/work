package com.test.work.domain.comment.repository

import com.test.work.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByWorkIdAndId(workId: Long, commentId:Long): Comment?
}