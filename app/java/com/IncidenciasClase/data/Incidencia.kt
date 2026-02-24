package com.incidenciasclase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incidencias")
data class Incidencia(
    @PrimaryKey(autoGenerate = true) val idIncidencia: Int = 0,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val nivelUrgencia: String,
    val fechaRegistro: String,
    val estado: String,
    val ubicacion: String
)
