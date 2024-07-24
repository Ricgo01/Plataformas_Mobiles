package org.example


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Ejercicio_1

    println("El promedio que se retorna es de:")
    val Lista : List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)
    println(calcularPromedio(Lista))

    println("")

    //Ejercicio_2

    println("Los numeros filtrados de la lista son:")
    val Lista_2 : List<Int> = listOf(1,3,4,5,7,8,10,11,13,15,16,18)
    val Lista_2_im = Lista_2.filter { it % 2 != 0 }
    println(Lista_2_im)

    println("")

    //Ejercicio_3
    val palabra : String = "rapar"
    println("La palabra $palabra es palindromo?")
    println(palindromo(palabra))

    println("")

    //Ejercicio_4
    println("Aqui estamos saludando a estas personas")
    val lista_Nombres = listOf("Pepe", "Juan", "Vanesa", "Pedro")
    println(saludos(lista_Nombres))

    println("")

    //Ejercicio_5

    val num1 : Int = 1
    val num2 : Int = 8
    println("la suma de los numeros $num1 y $num2 es de: ")
    println(performOperation(num1,num2){ x, y -> x + y })

    println("")

    //Ejercicio_6

    println("Se mostraran en pantalla los siguientes estuidantes")

    val persons = listOf( Person("Vianka" , 19, "Femenino"),
        Person("Kimberly" , 30, "Femenino"),
        Person("Angie" , 21, "Femenino"),
        Person("Peque" , 2, "Masculino")

    )

    val students = mapeo_Personas(persons)
    imprimir_Nombre(students)
}

//Funcion para calcular el promdeio en una lista de numeros
fun calcularPromedio (numbers: List<Int>): Int {

    val sum = numbers.reduce { acc, i -> acc + i }

    return sum/2
}

//Funcion para comprobar si una palabra es palindoromo o no
fun palindromo (word: String) : Boolean {

    if (word == word.reversed())
    {
        return true
    }

    else {
        return false
    }
}

//Funcion de mapeo para agregar un saludo antes de cada nombre

fun saludos (nombre: List<String>) : List<String> {

    val nombres_Saludos = nombre.map{ "Hola $it" }
    return nombres_Saludos

}

//Funcion para hacer operaciones entre dos numeros usnado lambdas

fun performOperation (a : Int, b: Int, operation: (Int, Int) -> Int) : Int {
    return operation(a,b)
}

//Clase Persona

data class Person(val name: String, val age: Int, val gender: String)

//Clase Estudainte
data class Student(val name: String, val age: Int, val gender: String, val
studentId: String)

//Funcion para mapear personas a un estudiante

fun mapeo_Personas (Person : List<Person>) : List <Student> {

    return Person.map { person: Person ->  Student(person.name, person.age, person.gender, generate_Id(person) ) }

}

//Funcion que genera un id juntanto el nombre y la edad de la persona

fun generate_Id (person : Person) : String {

    return person.name+person.age

}

//Funcion para imprimir los nombres de una lista de estudiantes

fun imprimir_Nombre (students : List<Student>){

    students.forEach{student: Student -> println("El estudiante ${student.name} tiene ${student.age} años")}
}



