package com.test.work.domain.work.service

import com.test.work.domain.user.repository.UserRepository
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
    private val userRepository: UserRepository
) : WorkService {
    override fun getAllWorkList(): List<WorkResponse> {
        return workRepository.findAll().map { it.toResponse() }
    }

    override fun getWorkById(workId: Long): WorkResponse {
        val work = workRepository.findByIdOrNull(workId) ?: throw WorkNotFoundException("Work", workId)
        return work.toResponse()
    }

    @Transactional
    override fun createWork(request: CreateWorkRequest): WorkResponse {
        val user = userRepository.findByIdOrNull(request.userId)?: throw WorkNotFoundException("User", null)
        return workRepository.save(
            Work(
                user = user,
                title = request.title,
                content = request.content,
                name = request.name,
                comment = request.content
            )
        ).toResponse()
    }

    @Transactional
    override fun updateWork(workId: Long, request: UpdateWorkRequest): WorkResponse {
        val work = workRepository.findByIdOrNull(workId) ?: throw WorkNotFoundException("Work",workId)
        val (title, content) = request

        work.title = title
        work.content = content

        return workRepository.save(work).toResponse()
    }

    @Transactional
    override fun deleteWork(workId: Long) {
        val work = workRepository.findByIdOrNull(workId) ?: throw WorkNotFoundException("Work", workId)
        workRepository.delete(work)
    }

}