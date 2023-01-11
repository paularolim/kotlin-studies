// https://kotlinlang.org/docs/inheritance.html

open class Lion(val name: String, val origin: String) {
    open fun sayHello() {
        println("$name, the lion from $origin says: graoooh")
    }
}

class AsiaticLion(name: String) : Lion(name, "China")

fun main() {
    val asiaticLion: Lion = AsiaticLion("Rufo")
    asiaticLion.sayHello()
}