package com.ejemplo.incidencias.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ejemplo.incidencias.data.repository.IncidenciaRepository
import com.ejemplo.incidencias.ui.screens.RegistroIncidenciaScreen
import com.ejemplo.incidencias.ui.screens.VerIncidenciasScreen
import com.ejemplo.incidencias.ui.viewmodel.IncidenciaViewModel

@Composable
fun AppNavigation(navController: NavHostController, context: Context) {
    val repository = IncidenciaRepository()
    val viewModel = IncidenciaViewModel(repository)

    NavHost(
        navController = navController,
        startDestination = Screen.RegistroIncidencia.route
    ) {
        composable(Screen.RegistroIncidencia.route) {
            RegistroIncidenciaScreen(
                viewModel = viewModel,
                onNavigateToVerIncidencias = {
                    navController.navigate(Screen.VerIncidencias.route)
                }
            )
        }

        composable(Screen.VerIncidencias.route) {
            VerIncidenciasScreen(
                viewModel = viewModel,
                onNavigateToRegistro = {
                    navController.navigate(Screen.RegistroIncidencia.route)
                }
            )
        }
    }
}
