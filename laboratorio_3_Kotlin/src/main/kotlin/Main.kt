package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    var hambuerguesaDeQueso = Burguer("Hamburquesa_De_Queso", 25.00)
    val hambuerguesaDePollo = Burguer("Hamburguesa_De_Pollo", 30.00)

    hambuerguesaDePollo.cook()
    println("")
    hambuerguesaDeQueso.cook()
    println("")

    val PizzaDePeperoni = Pizza("Pizza_De_Peperoni", 60.00)
    val PizzaMargarita = Pizza("Pizza_Margarita", 50.00)

    PizzaMargarita.cook()
    println("")
    PizzaDePeperoni.cook()
    println("")

    val Helado_de_Chocolate = IceCream("Helado_De_Chocolate", 10.00)
    val Helado_de_Vainilla = IceCream("Helado_De_Vainilla", 8.00)

    Helado_de_Vainilla.cook()
    println("")
    Helado_de_Chocolate.cook()
    println("")

    val Jugo_de_Fresa = Juice("Jugo_de_Fresa", 5.00)
    val Jugo_de_Naranja = Juice("Jugo_De_Naranja", 6.00)

    Jugo_de_Naranja.cook()
    println("")
    Jugo_de_Fresa.cook()
    println("")

    Helado_de_Chocolate.eat()

    hambuerguesaDePollo.discountedPrice(0.25)
    println(hambuerguesaDePollo.price)



}

fun Food.discountedPrice(discount:Double): Double{
    val discountPrice: Double = price*discount
    price -= discountPrice
    return price
}