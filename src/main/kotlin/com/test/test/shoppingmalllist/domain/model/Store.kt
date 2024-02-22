package com.test.test.shoppingmalllist.domain.model

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import jakarta.persistence.*

@Entity
@Table(name = "store")
class Store(
    @Column(name = "상호")
    val name: String, // 상호

    @Column(name = "도메인명")
    val url: String, // 도메인명

    @Column(name = "전화번호")
    val phone: String?, // 전화번호

    @Column(name = "운영자이메일")
    val email: String, // 운영자이메일

    @Column(name = "전체평가")
    val score : String, // 전체평가

    @Column(name = "모니터링날짜")
    val monitoringDate: String, // 모니터링 날짜

    @Column(name = "업소상태")
    var state : String, // 상태

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?= null
}


fun Store.toResponse(): StoreResponse {
    return StoreResponse(
        id = id !!,
        name= name,
        score= score,
        state= state,
        monitoringDate= monitoringDate
    )
}

