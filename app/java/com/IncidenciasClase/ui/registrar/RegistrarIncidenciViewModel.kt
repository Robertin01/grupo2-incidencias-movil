package com.incidenciasclase.ui.registrar

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incidenciasclase.data.Incidencia
import com.incidenciasclase.repository.IncidenciaRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

class RegistrarIncidenciaViewModel(
    private val repo: IncidenciaRepository
) : ViewModel() {

    var titulo = mutableStateOf("")
    var descripcion = mutableStateOf("")
    var categoria = mutableStateOf("Hardware")
    var nivelUrgencia = mutableStateOf("Normal")
    var fechaRegistro = mutableStateOf(LocalDate.now().toString())
    var estado = mutableStateOf("Abierta")
    var ubicacion = mutableStateOf("")

    fun registrar(onSuccess: () -> Unit) {
        if (titulo.value.isBlank() || descripcion.value.isBlank() || ubicacion.value.isBlank()) return

        val incidencia = Incidencia(
            titulo = titulo.value,
            descripcion = descripcion.value,
            categoria = categoria.value,
            nivelUrgencia = nivelUrgencia.value,
            fechaRegistro = fechaRegistro.value,
            estado = estado.value,
            ubicacion = ubicacion.value
        )

        viewModelScope.launch {
            repo.insertar(incidencia)
            limpiar()
            onSuccess()
        }
    }

    fun limpiar() {
        titulo.value = ""
        descripcion.value = ""
        categoria.value = "Hardware"
        nivelUrgencia.value = "Normal"
        fechaRegistro.value = LocalDate.now().toString()
        estado.value = "Abierta"
        ubicacion.value = ""
    }
}
