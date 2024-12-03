package day2

import java.io.File
import kotlin.math.abs

fun main() {
    var totalValid = 0;
    File("./src/main/kotlin/day2/input.txt").forEachLine { line ->
        val numbers = line.split(" ").map { it.toInt() }
        val isIncreasing = numbers[0] < numbers[1]

        val isSequential = if (isIncreasing) {
            numbers.equals(numbers.sorted());
        } else {
            numbers.equals(numbers.sortedDescending())
        }

        var isValid = isSequential

        var lastValue: Int? = null;

        numbers.forEach {
            if (lastValue != null) {
                val diff = abs(it - lastValue!!)
                if (diff > 3 || diff < 1) {
                    isValid = false
                }
            }

            lastValue = it
        }

        if (isValid) {
            totalValid++
        }
    }

    println(totalValid);
}