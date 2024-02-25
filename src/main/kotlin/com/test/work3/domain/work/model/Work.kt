package com.test.work3.domain.work.model

import com.test.work3.common.BaseTimeEntity
import com.test.work3.domain.work.dto.WorkRequest
import com.test.work3.domain.work.dto.WorkResponse
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "work")
@SQLRestriction("is_deleted <> true")
class Work(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "name")
    var name : String,

) : BaseTimeEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var workId: Long? = null

    fun updateWork(request: WorkRequest) {
        title = request.title
        content = request.content
    }

    fun deleteWork() {
        isDeleted = true
    }
}

fun Work.toResponse(): WorkResponse {
    return WorkResponse(
        id = workId!!,
        title = title,
        content = content,
        name = name,
        createAt = createdAt
    )
}