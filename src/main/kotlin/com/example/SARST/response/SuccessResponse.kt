package com.example.SARST.response

data class SuccessResponse(
    val status: String = "success",  // Este es el parámetro en el constructor primario
    val data: Any? = null            // Datos de la respuesta, que pueden ser de cualquier tipo
)
