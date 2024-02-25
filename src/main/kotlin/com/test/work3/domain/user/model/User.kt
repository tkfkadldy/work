package com.test.work3.domain.user.model

import com.test.work3.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "user")
class User (

    @Column(name = "name")
    var name: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "email")
    var email: String,

    @Enumerated(EnumType.STRING)
    val authority: UserType = UserType.USER

): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}