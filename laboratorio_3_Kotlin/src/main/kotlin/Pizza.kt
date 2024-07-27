package org.example

class Pizza (name: String, price: Double) : Food(name, price) {

    override fun cook() {
        println("Preparar la masa:\n" +
                "Preparar la pizza:\n" +
                "Añadir los ingredientes:\n" +
                "Hornear:\n" +
                "Servir")
    }
}