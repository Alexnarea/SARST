package com.example.SARST.response

data class FailResponse(
    val status: String = "fail",     // Este parámetro está en el constructor primario
    val data: Any? = null            // Los datos de la respuesta fallida, opcionales
)
