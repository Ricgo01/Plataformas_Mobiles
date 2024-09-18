package com.Lab_05_RG.ui.pantallas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Lab_05_RG.modelo.Eventos
import androidx.compose.ui.Modifier
import com.Lab_05_RG.modelo.Persona

@Composable
fun DetalleEventoPantalla(evento: Eventos, persona: Persona) {

    val isFavorito = remember { mutableStateOf(persona.favoritos.contains(evento)) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                Image(
                    painter = painterResource(id = evento.imagen),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = evento.nombre,
                    color = Color.White,
                    fontSize = 36.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF6200EE))
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextInfo(label = "Artista", info = evento.artista)
                    TextInfo(label = "Lugar", info = evento.lugar)
                    TextInfo(label = "Fecha", info = evento.fecha)
                    TextInfo(label = "Descripción", info = evento.descripcion)

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        BotonAccion(
                            texto = if (isFavorito.value) "Quitar Favorito" else "Agregar Favorito",
                            onClick = {
                                if (isFavorito.value) {
                                    persona.favoritos.remove(evento)
                                } else {
                                    persona.favoritos.add(evento)
                                }
                                isFavorito.value = !isFavorito.value
                            }
                        )

                        BotonAccion(texto = "Comprar", onClick = { /* Lógica de compra */ })
                    }
                }
            }
        }
    )
}

@Composable
fun TextInfo(label: String, info: String) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$label: $info",
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BotonAccion(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        Text(text = texto, fontSize = 16.sp)
    }
}