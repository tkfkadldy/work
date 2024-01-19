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
        return workRepository.findAll().map { it.toResponse() }
    }

    override fun getWorkById(workId: Long): WorkResponse {
        val work = workRepository.findByIdOrNull(workId) ?: throw WorkNotFoundException("Work", workId)
        return work.toResponse()
    }

    @Transactional
    override fun createWork(request: CreateWorkRequest): WorkResponse {
        return workRepository.save(
            Work(
                title = request.title,
                content = request.content,
                name = request.name
            )
        ).toResponse()
    }

    @Transactional
    override fun updateWork(workId: Long, request: UpdateWorkRequest): WorkResponse {
        val work = workRepository.findByIdOrNull(workId) ?: throw WorkNotFoundException("Work", workId)
        val (title, content,name) = request

        work.title = title
        work.content = content
        work.name = name

        return workRepository.save(work).toResponse()
    }

    @Transactional
    override fun deleteWork(workId: Long) {
        val work = workRepository.findByIdOrNull(workId) ?: throw WorkNotFoundException("Work", workId)
        workRepository.delete(work)
    }

}