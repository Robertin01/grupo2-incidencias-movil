package com.incidenciasclase.ui.registrar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegistrarIncidenciaScreen(
    viewModel: RegistrarIncidenciaViewModel,
    onRegistrada: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Registrar Incidencia", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.titulo.value,
            onValueChange = { viewModel.titulo.value = it },
            label = { Text("Título *") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.descripcion.value,
            onValueChange = { viewModel.descripcion.value = it },
            label = { Text("Descripción *") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.ubicacion.value,
            onValueChange = { viewModel.ubicacion.value = it },
            label = { Text("Ubicación *") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { viewModel.registrar(onRegistrada) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar Incidencia")
        }

        OutlinedButton(
            onClick = { viewModel.limpiar() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpiar Formulario")
        }
    }
}