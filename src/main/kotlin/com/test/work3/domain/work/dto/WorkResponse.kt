package com.test.work3.domain.work.dto

import com.test.work3.domain.work.model.Work
import java.time.ZonedDateTime

data class WorkResponse(
    val id : Long?,
    var title: String,
    var content: String,
    var name : String,
    var createAt: ZonedDateTime
){
    companion object {
        fun from(work : Work) : WorkResponse {
            return WorkResponse(
                id = work.workId !!,
                title = work.title,
                content = work.content,
                name = work.name,
                createAt = work.createdAt
            )
        }
    }
}
