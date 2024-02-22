package com.test.test.shoppingmalllist.domain.repository

import com.querydsl.core.types.Projections
import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import com.test.test.shoppingmalllist.domain.model.QStore
import com.test.test.shoppingmalllist.domain.model.Store
import com.test.test.shoppingmalllist.infra.querydsl.QueryDslSupport
import org.springframework.stereotype.Repository

@Repository
class StoreRepositoryImpl: QueryDslSupport(), CustomStoreRepository {

    private val store= QStore.store

    //검색 쿼리
    override fun searchStoreByName(name: String): MutableList<String>? =
        queryFactory
            .select(store.name)
            .from(store)
            .fetch()

    //전체조회 쿼리
    override fun searchScore(score: String): MutableList<Store>? =
        queryFactory
            .select(store)
            .from(store)
            .where(store.score.eq(score))
            .limit(40)
            .fetch()


    //업소상태
    override fun search(): Store? =
        queryFactory
        .select(store)
        .from(store)
        .limit(40)
        .fetchOne()
}