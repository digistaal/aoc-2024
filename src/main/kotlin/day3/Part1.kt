package day3

import java.io.File

fun main() {
    var inputString = ""
    File("./src/main/kotlin/day3/input.txt").forEachLine {
        inputString += it;
    }

    val regex = Regex("(?<=mul\\()\\d+,\\d+(?=\\))")
    val result = regex.findAll(inputString)
    var total = 0;
    result.iterator().forEach {
        val (x, y) = it.value.split(",").map { it.toInt() }
//        println("$x,$y")
        if (x in 1..999 && y in 1..999) {
            total += x * y
            println("in: $x,$y")
        } else {
            println("not in: $x,$y")
        }
    }

    println(total)
}