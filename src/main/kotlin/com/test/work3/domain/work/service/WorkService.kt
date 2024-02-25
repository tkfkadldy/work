package com.test.work3.domain.work.service

import com.test.work3.domain.work.dto.WorkRequest
import com.test.work3.domain.work.dto.WorkResponse

interface WorkService {

    fun getWorkList() : List<WorkResponse>

    //조회하기
    fun getWork(workId: Long) : WorkResponse

    //작성하기
    fun creatWork(request : WorkRequest) : WorkResponse

    //수정하기
    fun updateWork(workId: Long, request : WorkRequest) : WorkResponse

    //삭제하기
    fun deleteWork(workId : Long)
}