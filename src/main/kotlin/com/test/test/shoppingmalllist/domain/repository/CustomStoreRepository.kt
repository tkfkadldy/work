package com.test.test.shoppingmalllist.domain.repository

import com.test.test.shoppingmalllist.domain.model.Store
import com.test.test.shoppingmalllist.domain.model.StoreState

interface CustomStoreRepository {
    fun searchStoreListByKeyword(keyword : String) :List<Store>

    fun searchAll(): List<Store>

    fun search(name: String): Store?
}