package com.test.work.domain.work.controller

import com.test.work.domain.comment.exception.dto.ErrorResponse
import com.test.work.domain.work.dto.CreateWorkRequest
import com.test.work.domain.work.dto.UpdateWorkRequest
import com.test.work.domain.work.dto.WorkResponse
import com.test.work.domain.work.exception.WorkNotFoundException
import com.test.work.domain.work.service.WorkService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity as ResponseEntity

@RequestMapping("/works")
@RestController
class WorkController{

    //생성
    @PostMapping
    fun createWork(@RequestBody createWorkRequest: CreateWorkRequest) : ResponseEntity<WorkResponse> {
        TODO()
    }

    //목록단건조회
    @GetMapping("/{workId}")
    fun getWork(@PathVariable workId: Long) : ResponseEntity<WorkResponse> {
        TODO()
    }

    //목록조회
    @GetMapping()
    fun getWorkList(): ResponseEntity<List<WorkResponse>> {
        TODO()
    }

    //수정
    @PutMapping("/{workId}")
    fun updateWork(@PathVariable workId: Long, @RequestBody updateWorkRequest: UpdateWorkRequest) : ResponseEntity<WorkResponse> {
        TODO()
    }

    //삭제
    @DeleteMapping("/{workId}")
    fun deleteWork(@PathVariable workId: Long) : ResponseEntity<Unit> {
        TODO()
    }

}