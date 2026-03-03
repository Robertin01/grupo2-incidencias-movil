package com.incidenciasclase.verincidencias

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.incidenciasclase.data.Incidencia

@Composable
fun VerIncidencias() {

    val lista = listOf(
            Incidencia(1, "Ratón roto", "No funciona", "Hardware", "Baja", "10/02/2022", "Abierta", "Aula 2"),
            Incidencia(2, "Teclado", "Falla tecla A", "Hardware", "Baja", "11/02/2023", "Cerrada", "Aula 3"),
            Incidencia(3, "Internet", "No se conecta", "Red", "Alta", "11/02/2024", "Abierta", "Aula 5"),
            Incidencia(4, "Monitor", "Sin señal no enciende", "Hardware", "Media", "12/02/2026", "Abierta", "Aula 1")
    )

    Column(modifier = Modifier.padding(16.dp)) {

        Row {
            Button(onClick = { }) { Text("Ver incidencia") }
            Button(onClick = { }) { Text("Registrar incidencia") }
            Button(onClick = { }) { Text("Cerrar sesion") }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        LazyColumn {
            items(lista) {

                Card(modifier = Modifier.padding(4.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {

                        Text(text = "ID: " + it.idIncidencia)
                        Text(text = "Título: " + it.titulo)
                        Text(text = "Descripción: " + it.descripcion)
                        Text(text = "Categoría: " + it.categoria)
                        Text(text = "Urgencia: " + it.nivelUrgencia)
                        Text(text = "Fecha: " + it.fechaRegistro)
                        Text(text = "Estado: " + it.estado)
                        Text(text = "Ubicación: " + it.ubicacion)
                    }
                }
            }
        }
    }
}