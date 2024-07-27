package org.example

class IceCream (name: String, price: Double) : Food(name, price), Dessert {
    override fun cook() {
        println("Preparar la mezcla:\n" +
                "Enfriar la mezcla:\n" +
                "Romper los cristales de hielo:\n" +
                "Repetir el proceso:\n" +
                "Servir")
    }

    override fun eat() {
        println("Estas comiendo tu delicioso $name")
    }
}