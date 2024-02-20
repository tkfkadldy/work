package com.test.test.shoppingmalllist.domain.service

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import com.test.test.shoppingmalllist.domain.model.Store
import org.springdoc.core.converters.models.Pageable

interface StoreService {

    fun getStores() : List<StoreResponse>

    fun getStoresByPageable(pageable: Pageable) : List<StoreResponse>

    fun collectStoresFromCSV() : String

    fun collectStoresFromCSV2() : String

    fun collectStoresByAPI() : String

    fun searchStoreList(keyword: Long): List<StoreResponse>

    fun searchAll(): List<Store>

    fun search(name: String): Store?
}
