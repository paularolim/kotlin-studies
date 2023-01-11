// https://play.kotlinlang.org/byExample/02_control_flow/03_Ranges

fun main() {
    for (c in 'a'..'d') {
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) {
        print(c)
    }
    print(" ")

}