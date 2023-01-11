// https://kotlinlang.org/docs/inheritance.html

open class Dog {
    open fun sayHello() {
        println("wow wow")
    }
}

class Yorkshire : Dog() {
    override fun sayHello() {
        println("wif wif")
    }
}

fun main() {
    val dog: Dog = Dog()
    val yorkshire: Dog = Yorkshire()
    dog.sayHello()
    yorkshire.sayHello()
}