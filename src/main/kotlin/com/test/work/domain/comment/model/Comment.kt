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

    //댓글이 속한 게시물을 나타내며, `Post` 엔티티와 다대일 관계
    @ManyToOne
    @JoinColumn(name = "workid")
    val work: Work,

    //댓글을 작성한 사용자를 나타내며, `User` 엔티티와 다대일 관계

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
