package com.example.SARST.controller
import com.example.SARST.dto.WorkerDto
import com.example.SARST.response.SuccessResponse
import com.example.SARST.response.FailResponse
import com.example.SARST.response.ErrorResponse
import com.example.SARST.service.WorkerService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/workers")
class WorkerController {

    @Autowired
    lateinit var workerService: WorkerService

    @GetMapping
    fun getAllWorkers(): SuccessResponse {
        val workers = workerService.getAllWorkers()
        return SuccessResponse(data = workers)
    }

    @PostMapping
    fun create(@RequestBody @Valid workerDto: WorkerDto): Any {
        return try {
            val worker = workerService.save(workerDto)
            SuccessResponse(data = worker)
        } catch (e: Exception) {
            ErrorResponse(message = "Error al crear el trabajador", code = 500)
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid workerDto: WorkerDto): Any {
        return try {
            val worker = workerService.updateWorker(id, workerDto)
            SuccessResponse(data = worker)
        } catch (e: Exception) {
            ErrorResponse(message = "Error al actualizar el trabajador", code = 500)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Any {
        return try {
            workerService.deleteWorker(id)
            SuccessResponse(data = "Trabajador eliminado correctamente")
        } catch (e: Exception) {
            ErrorResponse(message = "Error al eliminar el trabajador", code = 500)
        }
    }

    @GetMapping("/{id}")
    fun getWorkerById(@PathVariable id: Long): Any {
        return try {
            val worker = workerService.getWorkerById(id)
            worker?.let {
                SuccessResponse(data = worker)
            } ?: FailResponse(data = "Trabajador no encontrado")
        } catch (e: Exception) {
            ErrorResponse(message = "Error al obtener el trabajador", code = 500)
        }
    }
}
