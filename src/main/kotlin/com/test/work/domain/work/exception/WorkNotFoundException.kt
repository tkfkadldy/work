package com.test.work.domain.work.exception

data class WorkNotFoundException(val work: String, val workId: Long?) :
    RuntimeException("$work not found with given id: $workId")

