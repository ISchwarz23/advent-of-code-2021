package utils

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.math.pow

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/main/resources", "$name.txt").readLines()

/**
 * Reads lines from the given input txt file as in values.
 */
fun readInputAsInts(name: String) = readInput(name).map { it.toInt() }

/**
 * Reads one line as String.
 */
fun readOneLineInputAsString(name: String): String {
    return readInput(name)[0]
}

/**
 * Reads one line and map to Ints.
 */
fun readOneLineInputAsInts(name: String, delimiter: String = ","): List<Int> {
    return readInput(name)[0].split(delimiter).map { it.toInt() }
}

fun readInputAs2dIntArray(name: String, delimiter: String = ""): List<List<Int>> {
    return readInput(name).map { it.toCharArray().map { c -> c.digitToInt() } }
}

/**
 * Converts string to com.schwarz.aoc.utils.md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Math util to calculate partial sum.
 */
fun Int.calcPartialSum(): Int = (this * (this + 1)) / 2
fun Long.calcPartialSum(): Long = (this * (this + 1)) / 2


infix fun Int.pow(exponent: Int): Int {
    return this.toDouble().pow(exponent).toInt()
}
