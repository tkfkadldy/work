package com.test.work3.domain.work.service

import com.test.work3.domain.work.dto.WorkRequest
import com.test.work3.domain.work.dto.WorkResponse
import com.test.work3.domain.work.model.Work
import com.test.work3.domain.work.repository.WorkRepository
import com.test.work3.domain.exception.ModelNotFoundException
import com.test.work3.domain.work.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class WorkServiceImpl(
    private val workRepository: WorkRepository
) : WorkService {
    override fun getWorkList(): List<WorkResponse> {
        return workRepository.findAll().map { it.toResponse() }
    }

    override fun getWork(workId: Long): WorkResponse {
        val work = workRepository.findByIdOrNull(workId) ?: throw ModelNotFoundException("Work", workId)
        return WorkResponse.from(work)
    }

    override fun creatWork(request: WorkRequest): WorkResponse {
        return Work(
            title = request.title,
            content = request.content,
            name = request.name
        ) .let {
            workRepository.save(it) }
            .let {
                WorkResponse.from(it) }
    }

    override fun updateWork(workId: Long, request: WorkRequest): WorkResponse {
        val work = workRepository.findByIdOrNull(workId) ?: throw ModelNotFoundException("Work", workId)

        work.updateWork(request)

        return workRepository.save(work)
            .let { WorkResponse.from(it) }
    }

    override fun deleteWork(workId: Long) {
        val work = workRepository.findByIdOrNull(workId) ?: throw ModelNotFoundException("Work", workId)

        work.deleteWork()

        workRepository.save(work)
    }

}