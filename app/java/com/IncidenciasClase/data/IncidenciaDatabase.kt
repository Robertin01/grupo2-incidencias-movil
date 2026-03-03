package com.incidenciasclase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Incidencia::class], version = 1)
abstract class IncidenciaDatabase : RoomDatabase() {

    abstract fun dao(): IncidenciaDao

    companion object {
        @Volatile private var INSTANCE: IncidenciaDatabase? = null

        fun get(context: Context): IncidenciaDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    IncidenciaDatabase::class.java,
                    "incidencias_db.sqlite"
                ).build().also { INSTANCE = it }
            }
    }
}