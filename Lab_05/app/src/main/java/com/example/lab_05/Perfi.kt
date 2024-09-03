package com.example.lab_05

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.lab_05.ui.theme.Lab_05Theme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp




data class Persona(val nombre: String, val favoritos: List<Eventos>)

class Perfil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_05Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        val persona = Persona(
                            nombre = "Ricardo Godinez",
                            favoritos = listOf(
                                ListaEventos.eventos[0],
                                ListaEventos.eventos[1]
                            )
                        )
                        PerfilUsuario(persona = persona, modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Composable
fun PerfilUsuario(persona: Persona, modifier: Modifier = Modifier) {
    Surface()
    {
        Image(
            painter = painterResource(id = R.drawable.fondo), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        modifier.fillMaxWidth()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                Image(
                    painter = painterResource(id = R.drawable.usuario),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                )

                Spacer(modifier = Modifier.height(43.dp))
                Text(
                    text = persona.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(50.dp),
                    color = Color.Black,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Cards(text = persona.nombre, image = R.drawable.usuario)
                Cards(text = "Favoritos", image = R.drawable.favorito)
                Cards(text = "Modificar Contraseña", image = R.drawable.invisible)
                Cards(text = "Notificaciones", image = R.drawable.notificacion)

            }
        }
    }
}

@Composable
fun Cards(text: String, image: Int) {
    OutlinedCard (
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.outlinedCardElevation()

    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(54.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PerfilUsuarioPreview() {
    val samplePersona = Persona(
        nombre = "Ricardo Godinez",
        favoritos = listOf(
            ListaEventos.eventos[0],
            ListaEventos.eventos[1]
        )
    )

    Lab_05Theme {
        PerfilUsuario(persona = samplePersona)
    }
}