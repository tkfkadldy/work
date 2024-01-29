package com.test.work.domain.work.model

import com.test.work.domain.comment.model.Comment
import com.test.work.domain.user.model.User
import com.test.work.domain.work.dto.WorkResponse
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name="work")
class Work(

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "name")
    var name : String,

    @Column(name = "comment")
    var comment: String,

    @Column(name = "createdAt")
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updateAt")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany( cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,


) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun deleteComment(comment: Comment) {
        comments.remove(comment)
    }
}

fun Work.toResponse(): WorkResponse {
    return WorkResponse(
        id = id!!,
        title = title,
        content = content,
        name = name
    )
}
