package com.test.one.domain.work.model

import com.test.one.domain.common.BaseTimeEntity
import com.test.one.domain.work.dto.WorkRequest
import com.test.one.domain.work.dto.WorkResponse
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "onework")
@SQLRestriction("is_deleted <> false")
class Work (
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "name")
    var name : String,

    /*@OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var maonis: MutableList<Maoni> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,*/

) : BaseTimeEntity()  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateWork(request: WorkRequest) {
        title = request.title
        content = request.content
    }

    fun deleteWork() {
        isDeleted = false
    }
}

fun Work.toResponse(): WorkResponse {
    return WorkResponse(
        id = id!!,
        title = title,
        content = content,
        name = name,
        createAt = createAt
    )
}
