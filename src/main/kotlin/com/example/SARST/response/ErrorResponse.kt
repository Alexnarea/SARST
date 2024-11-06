package com.example.SARST.response

data class ErrorResponse(
    val status: String = "error",    // Este parámetro está en el constructor primario
    val message: String? = null,    // Mensaje de error, opcional
    val code: Int? = null           // Código de error, opcional
)
