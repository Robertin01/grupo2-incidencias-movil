package com.incidenciasclase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.incidenciasclase.data.IncidenciaDatabase
import com.incidenciasclase.ui.login.LoginScreen
import com.incidenciasclase.ui.login.LoginViewModel
import com.incidenciasclase.ui.registrar.RegistrarIncidenciaScreen
import com.incidenciasclase.ui.registrar.RegistrarIncidenciaViewModel
import com.incidenciasclase.verincidencias.VerIncidencias

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val dao = IncidenciaDatabase.get(context).dao()
    val registrarViewModel = RegistrarIncidenciaViewModel(dao)
    val loginViewModel: LoginViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                viewModel = loginViewModel,
                onLoginCorrecto = { navController.navigate("ver_incidencias") }
            )
        }
        composable("ver_incidencias") {
            VerIncidencias(
                onRegistrar = { navController.navigate("registrar") },
                onCerrarSesion = {
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("registrar") {
            RegistrarIncidenciaScreen(
                viewModel = registrarViewModel,
                onRegistrada = { navController.navigate("ver_incidencias") }
            )
        }
    }
}