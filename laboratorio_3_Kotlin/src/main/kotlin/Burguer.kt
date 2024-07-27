package org.example

class Burguer (name: String, price: Double) : Food(name, price) {
    override fun cook() {
        println("Preparar la mezcla de carne:\n" +
                "Formar las hamburguesas:\n" +
                "Cocinar las hamburguesas:\n" +
                "Preparar los panes:\n" +
                "Montar las hamburguesas:\n" +
                "Servir y disfrutar:\n")
    }
}