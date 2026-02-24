package com.incidenciasclase.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IncidenciaDao {

    @Insert
    suspend fun insertar(incidencia: Incidencia)

    @Query("SELECT * FROM incidencias ORDER BY idIncidencia DESC")
    fun obtenerTodas(): Flow<List<Incidencia>>
}
