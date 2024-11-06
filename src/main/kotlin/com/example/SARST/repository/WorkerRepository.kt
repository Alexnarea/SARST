package com.example.SARST.repository

import com.example.SARST.entity.Worker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface WorkerRepository : JpaRepository<Worker, Long> {
}
