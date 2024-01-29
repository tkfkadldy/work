package com.test.work.domain.work.controller

import com.test.work.domain.work.dto.CreateWorkRequest
import com.test.work.domain.work.dto.UpdateWorkRequest
import com.test.work.domain.work.dto.WorkResponse
import com.test.work.domain.work.exception.WorkNotFoundException
import com.test.work.domain.work.exception.dto.ErrorResponse
import com.test.work.domain.work.model.Work
import com.test.work.domain.work.service.WorkService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity as ResponseEntity

@RequestMapping("/works")
@RestController
class WorkController(
    private val workService: WorkService
) {

    //생성
    @PostMapping
    fun createWork(@RequestBody createWorkRequest: CreateWorkRequest): ResponseEntity<WorkResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(workService.createWork(createWorkRequest))
    }

    //목록단건조회
    @GetMapping("/{workId}")
    fun getWork(@PathVariable workId: Long): ResponseEntity<WorkResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.getWorkById(workId))
    }

    //목록조회
    @GetMapping()
    fun getWorkList(): ResponseEntity<List<WorkResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.getAllWorkList())
    }

    //수정
    @PutMapping("/{workId}")
    fun updateWork(
        @PathVariable workId: Long,
        @RequestBody updateWorkRequest: UpdateWorkRequest
    ): ResponseEntity<WorkResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.updateWork(workId, updateWorkRequest))
    }


    //삭제
    @DeleteMapping("/{workId}")
    fun deleteWork(@PathVariable workId: Long) : ResponseEntity<Unit>{
        workService.deleteWork(workId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @ExceptionHandler(WorkNotFoundException::class)
    fun handlePostNotFoundException(e: WorkNotFoundException)
            : ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ErrorResponse(e.message))
    }
}