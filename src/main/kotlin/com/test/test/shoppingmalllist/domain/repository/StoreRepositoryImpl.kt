package com.test.test.shoppingmalllist.domain.repository

import com.querydsl.core.types.Projections
import com.test.test.shoppingmalllist.domain.model.QStore
import com.test.test.shoppingmalllist.domain.model.Store
import com.test.test.shoppingmalllist.domain.model.StoreState
import com.test.test.shoppingmalllist.infra.querydsl.QueryDslSupport
import org.springframework.stereotype.Repository

@Repository
class StoreRepositoryImpl: QueryDslSupport(), CustomStoreRepository {

    private val store= QStore.store

    //키워드 검색 쿼리
    override fun searchStoreListByKeyword(keyword: String): List<Store> =
        queryFactory.selectFrom(store)
            .where(store.keyword.containsIgnoreCase(keyword))
            .fetch()

    //전체조회 쿼리
    override fun searchAll(): List<Store> =
        queryFactory
            .selectFrom(store)
            .fetch()


    //업소상태
    override fun search(name: String): Store? =
        queryFactory
        .select(
            Projections.fields(
                Store::class.java,
                store.id,
                store.name
            )
        )
        .from(store)
        .where(store.name.eq(name))
        .fetchOne()

}