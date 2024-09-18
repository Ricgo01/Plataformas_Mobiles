package com.Lab_05_RG.ui.pantallas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Lab_05_RG.data.ListaEventos
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.res.painterResource

@Composable
fun ListaEventosPantalla(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Eventos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(color = Color(0xFF6A1B9A))
                .size(100.dp),
            color = Color.White,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(ListaEventos.eventos) { evento ->
                Cards(
                    name = evento.nombre,
                    artist = evento.artista,
                    image = evento.imagen,
                    onClick = {
                        navController.navigate("detalle_evento/${evento.nombre}")
                    }
                )
            }
        }
    }
}

@Composable
fun Cards(name: String, artist: String, image: Int, onClick: () -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 8.dp)
            )
            Column {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(text = artist, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

