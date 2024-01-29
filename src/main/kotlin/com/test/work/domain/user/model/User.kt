package com.test.work.domain.user.model

import com.test.work.domain.comment.model.Comment
import com.test.work.domain.user.dto.UserResponse
import com.test.work.domain.work.model.Work
import jakarta.persistence.*

@Entity
@Table(name = "work_user")
class User(

    @Column(name = "name", nullable = false)
    val name:String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var works: MutableList<Work> = mutableListOf(),

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        name = name,
        email = email,
        password = password
    )
}