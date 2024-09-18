package com.Lab_05_RG.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.Lab_05_RG.R
import com.Lab_05_RG.modelo.Persona


@Composable
fun PerfilPantalla(navController: NavHostController, persona: Persona) {
    Surface {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(90.dp))

                Image(
                    painter = painterResource(id = R.drawable.usuario),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
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
            ) {
                PerfilCard(text = persona.nombre, image = R.drawable.usuario)
                PerfilCard(text = "Favoritos", image = R.drawable.favorito) {
                    navController.navigate("favoritos")
                }
                PerfilCard(text = "Modificar Contraseña", image = R.drawable.invisible)
                PerfilCard(text = "Notificaciones", hasSwitch = true, image = R.drawable.notificacion)
            }
        }
    }
}

@Composable
fun PerfilCard(text: String, image: Int, hasSwitch: Boolean = false, onClick: (() -> Unit)? = null) {
    var isChecked by remember { mutableStateOf(false) }

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(onClick = { onClick?.invoke() }),
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
                    .size(54.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            if (hasSwitch) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.triangulos),
                    contentDescription = null,
                    modifier = Modifier
                        .size(54.dp)
                        .padding(end = 8.dp)
                )
            }
        }
    }
}