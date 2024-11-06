package com.example.SARST.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

class WorkerDto {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    var name: String? = null

    @NotNull(message = "Workstation is required")
    @NotBlank(message = "Workstation is required")
    var workstation: String? = null

    @NotNull(message = "Last Assignment is required")
    var lastAssignment: LocalDate? = null

    @NotNull(message = "Skills are required")
    var skill: String? = null
}
