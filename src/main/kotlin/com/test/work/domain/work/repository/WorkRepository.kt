package com.test.work.domain.work.repository

import com.test.work.domain.work.model.Work
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface WorkRepository : JpaRepository<Work, Long> {
/*
    fun findByTitleLike(keyword: String): List<Work>
    @Query("select p from Work p where p.title like %:title%)"
        fun searchByTitle(@Param("title") keyword: String): List<Work>*/
}