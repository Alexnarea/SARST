package com.example.SARST.mapper

import com.example.SARST.dto.WorkerDto
import com.example.SARST.entity.Worker
import org.springframework.stereotype.Component

@Component
object WorkerMapper {

    fun toEntity(workerDto: WorkerDto): Worker {
        val worker = Worker()
        worker.name = workerDto.name
        worker.workstation = workerDto.workstation
        worker.lastAssignment = workerDto.lastAssignment
        worker.skill = workerDto.skill
        return worker
    }

    fun toDto(worker: Worker): WorkerDto {
        val workerDto = WorkerDto()
        workerDto.name = worker.name
        workerDto.workstation = worker.workstation
        workerDto.lastAssignment = worker.lastAssignment
        workerDto.skill = worker.skill
        return workerDto
    }
}
