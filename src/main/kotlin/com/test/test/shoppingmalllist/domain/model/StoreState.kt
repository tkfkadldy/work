package com.test.test.shoppingmalllist.domain.model

enum class StoreState {
    STOPPED_SITE, CLOSING, PROMOTION, INFORMATION_MISMATCH, SITE_CLOSURE, OPEN, NOT_CHECKED
}

// 순서대로 사이트 운영중단, 휴업중, 광고용, 등록정보불일치, 사이트 폐쇄, 영업중, 확인안됨