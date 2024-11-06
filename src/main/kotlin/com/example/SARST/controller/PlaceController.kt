package com.example.SARST.controller

import com.example.SARST.dto.PlaceDto
import com.example.SARST.entity.Place
import com.example.SARST.response.SuccessResponse
import com.example.SARST.response.FailResponse
import com.example.SARST.response.ErrorResponse
import com.example.SARST.service.PlaceService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/workplaces")
class PlaceController {

    @Autowired
    lateinit var placeService: PlaceService

    // Obtener todos los lugares
    @GetMapping
    fun getAllPlaces(): ResponseEntity<Any> {
        return try {
            val places = placeService.getAllPlaces()
            ResponseEntity(SuccessResponse(data = places), HttpStatus.OK)
        } catch (e: Exception) {
            // Manejo de excepciones específicas si es necesario
            ResponseEntity(ErrorResponse(message = "Error al obtener los lugares", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Obtener un lugar por su ID
    @GetMapping("/{id}")
    fun getPlaceById(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val place = placeService.getPlaceById(id)
            place?.let {
                // Devuelves el lugar encontrado con una respuesta exitosa
                ResponseEntity(SuccessResponse(data = place), HttpStatus.OK)
            } ?: ResponseEntity(FailResponse(data = "Lugar no encontrado"), HttpStatus.NOT_FOUND)
        } catch (e: Exception) {
            // Manejo de errores internos si la excepción es más general
            ResponseEntity(ErrorResponse(message = "Error al obtener el lugar", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Crear un nuevo lugar
    @PostMapping
    fun create(@RequestBody @Valid placeDto: PlaceDto): ResponseEntity<Any> {
        return try {
            val place = placeService.save(placeDto)
            ResponseEntity(SuccessResponse(data = place), HttpStatus.CREATED)
        } catch (e: Exception) {
            // Si ocurre un error al guardar el lugar
            ResponseEntity(ErrorResponse(message = "Error al crear el lugar", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Actualizar un lugar existente
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid placeDto: PlaceDto): ResponseEntity<Any> {
        return try {
            val updatedPlace = placeService.update(id, placeDto)
            ResponseEntity(SuccessResponse(data = updatedPlace), HttpStatus.OK)
        } catch (e: Exception) {
            // Error al actualizar el lugar
            ResponseEntity(ErrorResponse(message = "Error al actualizar el lugar", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Eliminar un lugar por su ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            placeService.delete(id)
            // No se devuelve cuerpo en la respuesta, solo el código de estado
            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: Exception) {
            // Error al eliminar el lugar
            ResponseEntity(ErrorResponse(message = "Error al eliminar el lugar", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
