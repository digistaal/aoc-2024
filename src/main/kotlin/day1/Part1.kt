package day1

import java.io.File
import kotlin.math.abs

fun main() {
    val leftNumbers = mutableListOf<String>();
    val rightNumbers = mutableListOf<String>();

     File("./src/main/kotlin/day1/input.txt").forEachLine {
        val (leftNumber, rightNumber) = it.split("   ")
         leftNumbers.add(leftNumber)
         rightNumbers.add(rightNumber)
    }


    leftNumbers.sort()
    rightNumbers.sort()

    println(leftNumbers)
    println(rightNumbers)

    var total = 0;

    leftNumbers.forEachIndexed { index, leftNumber ->
        val rightNumber = rightNumbers[index]
        val difference = leftNumber.toInt() - rightNumber.toInt()
        total += abs(difference)
    }

    println(total)
}