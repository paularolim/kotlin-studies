// https://play.kotlinlang.org/byExample/06_scope_functions/04_apply

data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun main() {
    val jake = Person()
    jake.apply {
        name = "Jake"
        age = 30
        about = "Android developer"
    }
    println(jake.toString())
}