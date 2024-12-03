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


    val leftNumbersGroup = leftNumbers.groupingBy { it }.eachCount()
    val rightNumbersGroup = rightNumbers.groupingBy { it }.eachCount()

    var total = 0;

    leftNumbersGroup.forEach {
        val (key, count) = it
        val rightCount = rightNumbersGroup[key] ?: 0;
        total += count * rightCount * key.toInt()

    }


    println(total)

}