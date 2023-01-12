// https://play.kotlinlang.org/byExample/04_functional/01_Higher-Order%20Functions

fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x

fun main() {
    val func = operation()
    println(func(2))
}