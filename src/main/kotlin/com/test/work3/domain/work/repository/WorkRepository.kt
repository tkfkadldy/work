package com.test.work3.domain.work.repository

import com.test.work3.domain.work.model.Work
import org.springframework.data.jpa.repository.JpaRepository

interface WorkRepository : JpaRepository<Work,Long> {
}