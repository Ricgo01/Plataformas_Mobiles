package org.example

class Juice (name : String, price: Double) : Drink (name, price){

    override fun cook() {
        println("Lavar y preparar los ingredientes:\n" +
                "Licuar:\n" +
                "Colar (opcional):\n" +
                "Endulzar (opcional):\n" +
                "Servir")
    }

    override fun pour(): String {
        return "Se esta sirviendo $name."
    }
}