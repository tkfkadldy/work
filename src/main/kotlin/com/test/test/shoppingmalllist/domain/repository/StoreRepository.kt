package com.test.test.shoppingmalllist.domain.repository

import com.test.test.shoppingmalllist.domain.model.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long>, CustomStoreRepository {
}
