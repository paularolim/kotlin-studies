// https://kotlinlang.org/docs/sealed-classes.html
// https://play.kotlinlang.org/byExample/03_special_classes/03_Sealed%20Classes

sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
    }
}

fun main() {
    val cat: Mammal = Cat("Snowy")
    val human: Mammal = Human("Joe", "Dev")
    println(greetMammal(cat))
    println(greetMammal(human))
}