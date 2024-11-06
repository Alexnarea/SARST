package com.example.SARST.service

import com.example.SARST.dto.PlaceDto
import com.example.SARST.entity.Place
import com.example.SARST.mapper.PlaceMapper
import com.example.SARST.repository.PlaceRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PlaceService {

    @Autowired
    lateinit var placeRepository: PlaceRepository

    // Obtener todos los lugares
    fun getAllPlaces(): List<Place> {
        return placeRepository.findAll()
    }

    // Obtener un lugar por su ID
    fun getPlaceById(id: Long): Place {
        return placeRepository.findById(id).orElseThrow { EntityNotFoundException("Place not found with id: $id") }
    }

    // Guardar un nuevo lugar
    fun save(placeDto: PlaceDto): Place {
        val place = PlaceMapper.toEntity(placeDto)
        return placeRepository.save(place)
    }

    // Actualizar un lugar existente
    fun update(id: Long, placeDto: PlaceDto): Place {
        if (!placeRepository.existsById(id)) {
            throw EntityNotFoundException("Place not found with id: $id")
        }
        val place = PlaceMapper.toEntity(placeDto)
        place.id = id
        return placeRepository.save(place)
    }

    // Eliminar un lugar por su ID
    fun delete(id: Long) {
        if (!placeRepository.existsById(id)) {
            throw EntityNotFoundException("Place not found with id: $id")
        }
        placeRepository.deleteById(id)
    }
}
