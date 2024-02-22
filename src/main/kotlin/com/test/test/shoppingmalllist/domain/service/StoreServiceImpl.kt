package com.test.test.shoppingmalllist.domain.service

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import com.test.test.shoppingmalllist.domain.model.Store
import com.test.test.shoppingmalllist.domain.model.toResponse
import com.test.test.shoppingmalllist.domain.repository.StoreRepository
import org.springdoc.core.converters.models.Pageable
import org.springframework.stereotype.Service


@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository
) : StoreService {
    override fun getStores(): List<StoreResponse> {
        TODO("Not yet implemented")
    }

    override fun getStoresByPageable(pageable: Pageable): List<StoreResponse> {
        TODO("Not yet implemented")
    }

    override fun collectStoresFromCSV(): String {
        TODO("Not yet implemented")
    }

    override fun collectStoresFromCSV2(): String {
        TODO("Not yet implemented")
    }

    override fun collectStoresByAPI(): String {
        TODO("Not yet implemented")
    }


    override fun searchStoreByName(name: String): MutableList<String>? {
        return storeRepository.searchStoreByName(name)
    }

    override fun  searchScore(score: String): MutableList<Store>? {
        return storeRepository.searchScore(score)
    }

    override fun search(): Store?{
        return storeRepository.search()
    }
}