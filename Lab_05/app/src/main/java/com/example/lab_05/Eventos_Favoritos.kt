package com.example.lab_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_05.ListaEventos.eventos
import com.example.lab_05.ui.theme.Lab_05Theme

class Eventos_Favoritos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab_05Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        val eventoSeleccionado = listOf(ListaEventos.eventos[0], ListaEventos.eventos[1])
                        EventosSeleccionados(eventos = eventoSeleccionado, modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}
@Composable
fun EventosSeleccionados(eventos: List<Eventos>, modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Eventos Favoritos",
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF6A1B9A))
                .padding(20.dp),
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(eventos) { evento ->
                EventoCard(
                    name = evento.nombre,
                    artist = evento.artista,
                    image = evento.imagen
                )
            }
        }
    }
}

@Composable
fun EventoCard(name: String, artist: String, image: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),  // Espaciado entre las tarjetas
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)  // Ajusta la altura según lo necesario
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = artist,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventosSeleccionados() {
    val eventoSeleccionado = listOf(
        Eventos(
            nombre = "FerxxoTour",
            artista = "Feid",
            fecha = "25 de Octubre",
            lugar = "Distrito Futeca",
            descripcion = "Feid en concierto por primera vez en Guatemala, disfruta del evento el 25 de octubre",
            imagen = R.drawable.ferxxotour // Usa un recurso de imagen real aquí
        ),
        Eventos(
            nombre = "Bad Bunny World’s Hottest Tour",
            artista = "Bad Bunny",
            fecha = "15 de Diciembre",
            lugar = "Estadio Nacional Mateo Flores",
            descripcion = "Bad Bunny regresa a Guatemala como parte de su gira mundial, no te lo puedes perder.",
            imagen = R.drawable.bad_bunny // Usa un recurso de imagen real aquí
        )
    )

    Lab_05Theme {
        EventosSeleccionados(eventos = eventoSeleccionado)
    }
}
