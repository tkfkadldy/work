package com.test.test.shoppingmalllist.domain.repository

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import com.test.test.shoppingmalllist.domain.model.Store

interface CustomStoreRepository {
    fun searchStoreByName(name : String) : MutableList<String>?

    fun searchScore(score: String): MutableList<Store>?

    fun search(): Store?
}