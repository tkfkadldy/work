package com.test.test.shoppingmalllist.domain.dto

import org.springframework.data.domain.Sort

data class PageRequest(
    val page : Int,
    val size : Int,
    val sort : Int,
    val direction : Sort.Direction,
    val properties : String

)


// 객체 생성
//PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id").ascending())