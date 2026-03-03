package com.incidenciasclase.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var usuario = mutableStateOf("")
    var contrasena = mutableStateOf("")

    val formularioValido: Boolean
        get() = usuario.value.isNotBlank() && contrasena.value.isNotBlank()

    fun login(onSuccess: () -> Unit) {
        if (!formularioValido) return
        onSuccess()
    }
}