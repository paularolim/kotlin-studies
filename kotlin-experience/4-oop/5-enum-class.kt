// https://kotlinlang.org/docs/enum-classes.html
// https://play.kotlinlang.org/byExample/03_special_classes/02_Enum

enum class State {
    IDLE, RUNNING, FINISHED
}

fun main() {
    val state = State.RUNNING
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)
}