package com.test.test.shoppingmalllist.domain.dto

import com.test.test.shoppingmalllist.domain.model.StoreState

data class StoreResponse (
 val id : Long,
 val name:String,
 //전체평가
 val score : String,
 // 업소상태
 val state: String,
 // 모니터링날짜
 val monitoringDate : String
    // 32개의 칼럼 중 여기에 어떤 칼럼이 들어가야 하는지?
)