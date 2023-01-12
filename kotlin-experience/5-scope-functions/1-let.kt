// https://play.kotlinlang.org/byExample/06_scope_functions/01_let

val empty = "test".let {
    customPrint(it)
    it.isEmpty()
}
println(" is empty: $empty")


fun printNonNull(str: String?) {
    println("Printing \"$str\":")

    str?.let {
        print("\t")
        customPrint(it)
        println()
    }
}

fun printIfBothNonNull(strOne: String?, strTwo: String?) {
    strOne?.let { firstString ->
        strTwo?.let { secondString ->
            customPrint("$firstString : $secondString")
            println()
        }
    }
}

printNonNull(null)
printNonNull("my string") 
printIfBothNonNull("First","Second") 