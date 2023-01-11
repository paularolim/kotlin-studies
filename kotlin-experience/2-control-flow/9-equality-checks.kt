// https://play.kotlinlang.org/byExample/02_control_flow/04_Equality%20Checks

fun main() {
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")
    val x = authors

    println(authors == writers)
    println(authors === writers)
    println(authors === x)
}