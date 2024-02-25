package com.test.work3.domain.maoni.model

import com.test.work3.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name= "maoni")
class Maoni(
    //댓글
    @Column(name ="maoni")
    val maoni: String,

) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}