package com.Lab_05_RG

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Lab_05_RG.data.ListaEventos
import com.Lab_05_RG.ui.pantallas.ListaEventosPantalla
import com.Lab_05_RG.ui.pantallas.PerfilPantalla
import com.Lab_05_RG.ui.theme.Lab05_1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.Lab_05_RG.modelo.Persona
import com.Lab_05_RG.ui.pantallas.DetalleEventoPantalla
import com.Lab_05_RG.ui.pantallas.FavoritosPantalla
import com.Lab_05_RG.data.ListaPersonas

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab05_1Theme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                val scrimColor = if (drawerState.isOpen) Color(0x80000000) else Color.Transparent

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = true,
                    drawerContent = {
                        DrawerContent(navController, drawerState, scope, drawerState.isOpen)
                    },
                    scrimColor = scrimColor
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("App de Eventos") },
                                navigationIcon = {
                                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Abrir menú"
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(
                                    containerColor = Color(0xFF6200EE),
                                    titleContentColor = Color.White
                                )
                            )
                        }
                    ) { innerPadding ->
                        NavigationGraph(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    val persona = Persona(
        nombre = "Ricardo Godinez",
        favoritos = mutableListOf()
    )

    NavHost(navController = navController, startDestination = "lista_eventos") {
        composable("lista_eventos") {
            ListaEventosPantalla(navController)
        }
        composable("perfil") {
            PerfilPantalla(navController, persona)
        }
        composable("favoritos") {
            FavoritosPantalla(navController, persona)
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    val persona = ListaPersonas.persona

    NavHost(
        navController = navController,
        startDestination = "lista_eventos",
        modifier = modifier
    ) {
        composable("lista_eventos") {
            ListaEventosPantalla(navController = navController)
        }

        composable(route = "perfil") {
            PerfilPantalla(navController = navController, persona = persona)
        }

        composable("favoritos") {
            FavoritosPantalla(
                navController = navController,
                persona = persona
            )
        }

        composable(route = "detalle_evento/{eventoId}") { backStackEntry ->
            val eventoId = backStackEntry.arguments?.getString("eventoId")
            val evento = ListaEventos.eventos.find { it.nombre == eventoId }

            evento?.let {
                DetalleEventoPantalla(evento = it, persona = persona)
            }
        }
    }
}



@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState, scope: CoroutineScope, isDrawerOpen: Boolean) {
    val backgroundColor = if (isDrawerOpen) Color(0xFFBB86FC) else Color.Transparent

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Text(
            text = "Menú",
            modifier = Modifier
                .padding(5.dp),
            style = MaterialTheme.typography.titleLarge
        )
        Divider()

        DrawerItem("Lista de Eventos", navController, drawerState, "lista_eventos", scope)
        DrawerItem("Perfil", navController, drawerState, "perfil", scope)
        DrawerItem("Favoritos", navController, drawerState, "favoritos", scope)
    }
}

@Composable
fun DrawerItem(label: String, navController: NavHostController, drawerState: DrawerState, route: String, scope: CoroutineScope) {
    Text(
        text = label,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(route) {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch { drawerState.close() }
            }
    )
}


