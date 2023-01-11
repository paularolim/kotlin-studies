// https://play.kotlinlang.org/byExample/01_introduction/03_Variables

fun someCondition() = true

fun main() {
    var a: String = "initial"
    println(a)
    val b: Int = 1
    val c = 3

    // error
    var e: Int
    println(e)

    val d: Int
    if (someCondition()) {
        d = 1
    } else {
        d = 2
    }
    println(d)
}