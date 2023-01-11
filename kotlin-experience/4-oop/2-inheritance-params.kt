// https://kotlinlang.org/docs/inheritance.html

open class Tiger(val origin: String) {
    open fun sayHello() {
        println("A tiger from $origin says grrrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")

fun main() {
    val siberianTiger: Tiger = SiberianTiger()
    siberianTiger.sayHello()
}