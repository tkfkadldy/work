package com.test.work.domain.work.service

import com.test.work.domain.work.dto.CreateWorkRequest
import com.test.work.domain.work.dto.UpdateWorkRequest
import com.test.work.domain.work.dto.WorkResponse
import com.test.work.domain.work.exception.WorkNotFoundException
import com.test.work.domain.work.model.Work
import com.test.work.domain.work.model.toResponse
import com.test.work.domain.work.repository.WorkRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WorkServiceImpl(
    private val workRepository: WorkRepository,
) :WorkService {
    override fun getAllWorkList(): List<WorkResponse> {
        TODO()
    }

    override fun getWorkById(workId: Long): WorkResponse {
        TODO()
    }

    @Transactional
    override fun createWork(request: CreateWorkRequest): WorkResponse {
        TODO()
    }

    @Transactional
    override fun updateWork(workId: Long, request: UpdateWorkRequest): WorkResponse {
        TODO()
    }

    @Transactional
    override fun deleteWork(workId: Long) {
        TODO()
    }

}