package com.test.work.domain.work.dto

data class CreateWorkRequest(
    val userId:Long,
    val title:String,
    val content: String,
    val name : String
)
