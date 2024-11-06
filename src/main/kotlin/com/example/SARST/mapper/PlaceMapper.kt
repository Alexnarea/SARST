package com.example.SARST.mapper

import com.example.SARST.dto.PlaceDto
import com.example.SARST.entity.Place

object PlaceMapper {
    fun toEntity(placeDto: PlaceDto): Place {
        val place = Place()
        place.name = placeDto.name
        place.location = placeDto.location
        place.assignmentDate = placeDto.assignmentDate
        place.requiredSkill = placeDto.requiredSkill
        return place
    }

    fun toDto(place: Place): PlaceDto {
        val placeDto = PlaceDto()
        placeDto.name = place.name
        placeDto.location = place.location
        placeDto.assignmentDate = place.assignmentDate
        placeDto.requiredSkill = place.requiredSkill
        return placeDto
    }
}