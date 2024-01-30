package com.test.work.domain.comment.model

import com.test.work.domain.comment.dto.CommentResponse
import com.test.work.domain.user.model.User
import com.test.work.domain.work.model.Work
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment (
    @Column(name = "comment", nullable = false)
    var comment: String,

    @ManyToOne
    @JoinColumn(name = "workid")
    val work: Work,

    @ManyToOne
    @JoinColumn(name = "userid")
    val user: User

){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        comment = comment
    )
}
