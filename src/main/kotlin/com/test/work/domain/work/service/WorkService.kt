package com.test.work.domain.work.service

import com.test.work.domain.work.dto.CreateWorkRequest
import com.test.work.domain.work.dto.UpdateWorkRequest
import com.test.work.domain.work.dto.WorkResponse

interface WorkService {
    fun getAllWorkList() : List<WorkResponse>

    fun getWorkById(workId : Long) : WorkResponse

    fun createWork(request: CreateWorkRequest): WorkResponse

    fun updateWork(workId: Long, request: UpdateWorkRequest): WorkResponse

    fun deleteWork(workId: Long)
}