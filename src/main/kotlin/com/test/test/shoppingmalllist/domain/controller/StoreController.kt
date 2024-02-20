package com.test.test.shoppingmalllist.domain.controller

import com.test.test.shoppingmalllist.domain.dto.StoreResponse
import com.test.test.shoppingmalllist.domain.service.StoreService
import org.springdoc.core.converters.models.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/stores")
@RestController
class StoreController(
    private val storeService : StoreService
) {
// 모든 가게 정보를 조회하기
    @GetMapping("/store", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStores(): ResponseEntity<List<StoreResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStores())
    }

    // Pagination을 사용하여 모든 가게 정보를 조회하기
    @GetMapping
    fun getStoresByPageable(pageable: Pageable) : ResponseEntity<List<StoreResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStoresByPageable(pageable))
    }

    // 특정 위치의 CSV 파일로부터 1개 행씩 데이터를 DB에 저장
    @PostMapping("/collection", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun collectStoresFromCSV() : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.collectStoresFromCSV())
    }

    //특정 위치의 CSV 파일로부터 전체 데이터를 DB에 저장
    @PostMapping("/collection2", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun collectStoresFromCSV2() : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.collectStoresFromCSV2())
    }

// API를 사용해서 데이터를 수집하기
    @PostMapping("/collection-api", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun collectStoresByAPI() : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.OK).body(storeService.collectStoresByAPI())
    }

    /*@GetMapping("/api/reviews")
    fun getReviews(
        @RequestParam(required = false, defaultValue = "0", value = "page") pageNo: Int,
        @RequestParam(required = false, defaultValue = "createdAt", value = "criteria") criteria: String?
    ): SuccessResponseDto<List<ReviewResponseDto>> {
        return reviewService.getReviews(pageNo, criteria)
    }*/

    @GetMapping("/search")
    fun searchStoreList(@RequestParam(value = "keyword") keyword : Long) :ResponseEntity<List<StoreResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(storeService.searchStoreList(keyword))
    }
}