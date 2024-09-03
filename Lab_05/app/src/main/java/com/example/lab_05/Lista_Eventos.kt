package com.example.lab_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_05.ui.theme.Lab_05Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_05Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        ListaDeEventos(eventos = ListaEventos.eventos, modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Composable
fun Cards(name: String, artist: String, image: Int) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.outlinedCardElevation()
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
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(text = artist, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun ListaDeEventos(eventos: List<Eventos>, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        modifier.fillMaxSize()
        modifier.padding(16.dp)

        Text(
            text = "Eventos",
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color(0xFF6A1B9A))
                .padding(20.dp),
            color = Color.White,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )



        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(eventos) { evento ->
                Cards(
                    name = evento.nombre,
                    artist = evento.artista,
                    image = evento.imagen
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Lab_05Theme {

        val eventos = listOf(
            Eventos(
                "FerxxoTour", "Feid", "25 de Octubre", "Distrito Futeca",
                "Feid en concierto por primera vez en Guatemala, disfruta del evento el 25 de octubre",
                R.drawable.ferxxotour
            ),
            Eventos(
                "Bad Bunny World’s Hottest Tour",
                "Bad Bunny",
                "15 de Diciembre",
                "Estadio Nacional Mateo Flores",
                "Bad Bunny regresa a Guatemala como parte de su gira mundial, no te lo puedes perder.",
                R.drawable.bad_bunny
            ),
            Eventos(
                "Coldplay Music of the Spheres",
                "Coldplay",
                "12 de Noviembre",
                "Parque de la Industria",
                "Coldplay llega a Guatemala en su gira Music of the Spheres, con un show lleno de luz y energía.",
                R.drawable.coldplay
            )
        )

        ListaDeEventos(eventos = eventos)
    }
}