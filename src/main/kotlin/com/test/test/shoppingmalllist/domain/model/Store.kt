package com.test.test.shoppingmalllist.domain.model

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "stores")
class Store(
    @Column(name = "name")
    val name: String, // 상호명

    @Column(name = "url")
    val url: String, // 도메인

    @Column(name = "phone")
    val phone: String?, // 대표 번호

    @Column(name = "email")
    val email: String, // 대표 이메일

    @Column(name = "score")
    val score : Int, // 점수

    @Column(name = "monitoring_date")
    val monitoringDate: String, // 모니터링 날짜

    @Column(name = "keyword")
    val keyword : String, // 키워드

    @Column(name = "store_state")
    @Enumerated(EnumType.STRING)
    var state : StoreState, // 상태

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?= null
}

fun Store.toResponse(): StoreResponse {
    return StoreResponse(
        id = id !!,
        score = score,
        state = state,
        monitoringDate = monitoringDate
    )
}
