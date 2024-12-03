package day2

import java.io.File
import kotlin.math.abs


fun isSequenceValid(sequence: List<Int>): Boolean {
    val isIncreasing = sequence[0] < sequence[1]

    val isSequential = if (isIncreasing) {
        sequence.equals(sequence.sorted());
    } else {
        sequence.equals(sequence.sortedDescending())
    }

    var isValid = isSequential

    var lastValue: Int? = null;

    sequence.forEach {
        if (lastValue != null) {
            val diff = abs(it - lastValue!!)
            if (diff > 3 || diff < 1) {
                isValid = false
            }
        }

        lastValue = it
    }

    return isValid
}

fun main() {
    var totalValid = 0;
    File("./src/main/kotlin/day2/input.txt").forEachLine { line ->
        val numbers = line.split(" ").map { it.toInt() }

        var isValid = isSequenceValid(numbers)

        if (isValid) {
            totalValid++

            return@forEachLine
        }


        for (idx in numbers.indices) {
            val sequenceToCompare = numbers.toMutableList()
            sequenceToCompare.removeAt(idx)

            val isValidWithRemovedIdx = isSequenceValid(sequenceToCompare);

            if (isValidWithRemovedIdx) {
                isValid = true
            }
        }

        if (isValid) {
            totalValid++
        }
    }

    println(totalValid);
}