package com.example.SARST.service

import com.example.SARST.dto.WorkerDto
import com.example.SARST.entity.Worker
import com.example.SARST.mapper.WorkerMapper
import com.example.SARST.repository.WorkerRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorkerService {

    @Autowired
    lateinit var workerRepository: WorkerRepository

    @Autowired
    lateinit var workerMapper: WorkerMapper

    // Obtener todos los trabajadores
    fun getAllWorkers(): List<WorkerDto> {
        val workers = workerRepository.findAll()
        return workers.map { workerMapper.toDto(it) } // Mapeo a DTO
    }

    // Crear un nuevo trabajador
    fun save(workerDto: WorkerDto): WorkerDto {
        val worker = workerMapper.toEntity(workerDto) // Mapeo de DTO a entidad
        val savedWorker = workerRepository.save(worker)
        return workerMapper.toDto(savedWorker) // Mapeo de vuelta a DTO
    }

    // Obtener un trabajador por ID
    fun getWorkerById(id: Long): WorkerDto {
        val worker = workerRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Worker not found with id $id") }
        return workerMapper.toDto(worker) // Mapeo de entidad a DTO
    }

    // Actualizar un trabajador completo
    fun updateWorker(id: Long, workerDto: WorkerDto): WorkerDto {
        val worker = workerRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Worker not found with id $id") }
        worker.name = workerDto.name
        worker.workstation = workerDto.workstation
        worker.lastAssignment = workerDto.lastAssignment
        val updatedWorker = workerRepository.save(worker)
        return workerMapper.toDto(updatedWorker)
    }

    // Actualizar parcialmente el nombre de un trabajador
    fun updateWorkerName(id: Long, workerDto: WorkerDto): WorkerDto {
        val worker = workerRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Worker not found with id $id") }
        worker.name = workerDto.name // Solo actualizamos el nombre
        val updatedWorker = workerRepository.save(worker)
        return workerMapper.toDto(updatedWorker)
    }

    // Eliminar un trabajador
    fun deleteWorker(id: Long) {
        val worker = workerRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Worker not found with id $id") }
        workerRepository.delete(worker)
    }
}
