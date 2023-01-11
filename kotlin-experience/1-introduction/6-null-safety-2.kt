// https://play.kotlinlang.org/byExample/01_introduction/04_Null%20Safety

fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}

fun main() {
    println(describeString(null))
}