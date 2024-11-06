package com.example.SARST.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

class PlaceDto {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    var name: String? = null

    @NotNull(message = "location is required")
    @NotBlank(message = "location is required")
    var location: String? = null

    @NotNull(message = "Last Assignment is required")
    var assignmentDate: LocalDate? = null

    @NotNull(message = "Skills are required")
    var requiredSkill: String? = null
}