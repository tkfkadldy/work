package com.test.one.domain.work.repository

import com.test.one.domain.work.model.Work
import org.springframework.data.jpa.repository.JpaRepository

interface WorkRepository : JpaRepository<Work,Long> {
}