package com.test.test.shoppingmalllist.domain.service

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import com.test.test.shoppingmalllist.domain.model.Store
import com.test.test.shoppingmalllist.domain.model.toResponse
import com.test.test.shoppingmalllist.domain.repository.StoreRepositoryImpl
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


    override fun searchStoreList(keyword: Long): List<StoreResponse> {
        return storeRepository.searchStoreListByKeyword(keyword.toString()).map { it.toResponse() }
    }

    override fun searchAll(): List<Store> {
        return storeRepository.searchAll()
    }

    override fun search(name: String): Store? {
        return storeRepository.search(name)
    }
}