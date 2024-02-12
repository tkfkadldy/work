package com.test.one.domain.work.controller

import com.test.one.domain.work.dto.WorkRequest
import com.test.one.domain.work.dto.WorkResponse
import com.test.one.domain.work.service.WorkService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/works")
@RestController
class WorkController(
    private val workService: WorkService
){
    @GetMapping("/{workId}")
    fun getWork(
        @PathVariable workId: Long
    ): ResponseEntity<WorkResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.getWork(workId))
    }

    //목록조회
    @GetMapping
    fun getWorkList() : ResponseEntity<List<WorkResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.getWorkList())
    }

    //생성
    @PostMapping
    fun createWork(
        @RequestBody workRequest: WorkRequest
    ): ResponseEntity<WorkResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.creatWork(workRequest))
    }

    //수정
    @PutMapping("/{workId}")
    fun updateWork(
        @PathVariable workId: Long,
        @RequestBody workRequest: WorkRequest
    ): ResponseEntity<WorkResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(workService.updateWork(workId,workRequest))
    }


    //삭제
    @DeleteMapping("/{workId}")
    fun deleteWork(
        @PathVariable workId: Long
    ) : ResponseEntity<Unit> {
        workService.deleteWork(workId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}