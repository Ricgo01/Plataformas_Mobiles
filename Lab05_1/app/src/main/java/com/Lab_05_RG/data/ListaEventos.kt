package com.Lab_05_RG.data

import com.Lab_05_RG.R
import com.Lab_05_RG.modelo.Eventos

object ListaEventos {
    val eventos = listOf(
        Eventos(
            nombre = "FerxxoTour",
            artista = "Feid",
            fecha = "25 de Octubre",
            lugar = "Distrito Futeca",
            descripcion = "Feid en concierto por primera vez en Guatemala, disfruta del evento el 25 de octubre",
            imagen = R.drawable.ferxxotour
        ),
        Eventos(
            nombre = "World’s Hottest Tour",
            artista = "Bad Bunny",
            fecha = "15 de Diciembre",
            lugar = "Estadio Nacional Mateo Flores",
            descripcion = "Bad Bunny regresa a Guatemala como parte de su gira mundial, no te lo puedes perder.",
            imagen = R.drawable.bad_bunny
        ),
        Eventos(
            "Music of the Spheres",
            "Coldplay",
            "12 de Noviembre",
            "Parque de la Industria",
            "Coldplay llega a Guatemala en su gira Music of the Spheres, con un show lleno de luz y energía.",
            R.drawable.coldplay
        ),
        Eventos(
            "Love On Tour",
            "Harry Styles",
            "8 de Noviembre",
            "Tikal Futura",
            "Harry Styles trae su Love On Tour a Guatemala, no te pierdas este evento increíble.",
            R.drawable.harry_styles
        ),
        Eventos(
            "Future Nostalgia Tour",
            "Dua Lipa",
            "30 de Octubre",
            "Expo Center Guatemala",
            "Dua Lipa presenta su exitoso álbum Future Nostalgia en un concierto imperdible.",
            R.drawable.dua_lipa
        ),
        Eventos(
            "After Hours Tour",
            "The Weeknd",
            "22 de Septiembre",
            "Estadio Cementos Progreso",
            "The Weeknd llega con su After Hours Tour a Guatemala, prepárate para una noche inolvidable.",
            R.drawable.the_weeknd
        )
    )
}