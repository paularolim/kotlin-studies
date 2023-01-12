// https://play.kotlinlang.org/byExample/06_scope_functions/03_with

class Configuration(val host: String, val port: Int) 

fun main() {
    val configuration = Configuration(host = "127.0.0.1", port = 9000) 

    with(configuration) {
        println("$host:$port")
    }

    // alternative
    configuration.run {
        println("$host:$port")
    }

    // instead of:
    println("${configuration.host}:${configuration.port}")    
}