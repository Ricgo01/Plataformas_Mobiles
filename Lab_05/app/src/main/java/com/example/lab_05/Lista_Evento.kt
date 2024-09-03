package com.example.lab_05

data class Eventos(val nombre: String, val artista: String, val fecha: String, val lugar: String, val descripcion: String, val imagen: Int)

object ListaEventos {
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
        ),
        Eventos(
            "Harry Styles Love On Tour",
            "Harry Styles",
            "8 de Noviembre",
            "Tikal Futura",
            "Harry Styles trae su Love On Tour a Guatemala, no te pierdas este evento increíble.",
            R.drawable.harry_styles
        ),
        Eventos(
            "Dua Lipa Future Nostalgia Tour",
            "Dua Lipa",
            "30 de Octubre",
            "Expo Center Guatemala",
            "Dua Lipa presenta su exitoso álbum Future Nostalgia en un concierto imperdible.",
            R.drawable.dua_lipa
        ),
        Eventos(
            "The Weeknd After Hours Tour",
            "The Weeknd",
            "22 de Septiembre",
            "Estadio Cementos Progreso",
            "The Weeknd llega con su After Hours Tour a Guatemala, prepárate para una noche inolvidable.",
            R.drawable.the_weeknd
        )
    )
}