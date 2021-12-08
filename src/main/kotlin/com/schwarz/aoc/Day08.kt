package com.schwarz.aoc

object Day08 {

    fun part1(input: List<SignalInput>): Int {
        return input.sumOf {
            it.outputPatterns.count { pattern ->
                pattern.length == 2 || pattern.length == 3 || pattern.length == 4 || pattern.length == 7
            }
        }
    }

    fun part2(input: List<SignalInput>): Int {
        return input.sumOf {
            val digitIdentifier = DigitIdentifier(it.signalPatterns)

            it.outputPatterns
                .map { pattern -> digitIdentifier.resolve(pattern) }
                .joinToString("")
                .toInt()
        }
    }

}

class DigitIdentifier(private val trainingData: List<String>) {

    private val digitResolution = mutableMapOf<String, Char>()

    init {
        val trainingData = this.trainingData.map { it.sorted() }

        // unique patterns
        val pattern1 = trainingData.findOrThrow { it.length == 2 }
        val pattern7 = trainingData.findOrThrow { it.length == 3 }
        val pattern4 = trainingData.findOrThrow { it.length == 4 }
        val pattern8 = trainingData.findOrThrow { it.length == 7 }

        // identify 0, 6 and 9
        val searchPattern0 = pattern4 - pattern1
        val pattern0 = trainingData.findOrThrow { it.length == 6 && it.containsAll(searchPattern0.toCharArray()).not() }
        val segmentCenter = pattern8 - pattern0
        val pattern6 = trainingData.findOrThrow {
            it.length == 6 && it.contains(segmentCenter) && it.containsAll(pattern1.toCharArray()).not()
        }
        val pattern9 = trainingData.findOrThrow {
            it.length == 6 && it.contains(segmentCenter) && it.containsAll(pattern1.toCharArray())
        }

        // identify 2, 3 and 5
        val segmentTopRight = pattern8 - pattern6
        val segmentBottomLeft = pattern8 - pattern9
        val pattern2 = trainingData.findOrThrow { it.length == 5 && it.contains(segmentBottomLeft) }
        val pattern3 = trainingData.findOrThrow { it.length == 5 && it.containsAll(pattern1.toCharArray()) }
        val pattern5 = trainingData.findOrThrow {
            it.length == 5 && it.contains(segmentBottomLeft).not() && it.contains(segmentTopRight).not()
        }

        digitResolution[pattern0] = '0'
        digitResolution[pattern1] = '1'
        digitResolution[pattern2] = '2'
        digitResolution[pattern3] = '3'
        digitResolution[pattern4] = '4'
        digitResolution[pattern5] = '5'
        digitResolution[pattern6] = '6'
        digitResolution[pattern7] = '7'
        digitResolution[pattern8] = '8'
        digitResolution[pattern9] = '9'
    }

    fun resolve(pattern: String): Char {
        return digitResolution[pattern.sorted()] ?: throw IllegalArgumentException("Unknown pattern")
    }

    private fun <T> List<T>.findOrThrow(
        ex: RuntimeException = RuntimeException("Can't find item using given predicate."),
        predicate: (T) -> Boolean
    ): T {
        return this.find(predicate) ?: throw ex
    }

    private fun String.sorted(): String {
        return this.toCharArray().sorted().joinToString("")
    }

    private fun String.containsAll(chars: CharArray): Boolean {
        return chars.find { this.contains(it).not() } == null
    }

    private operator fun String.minus(other: String): String {
        var result = this
        other.toCharArray().forEach { result = result.replace("$it", "") }
        return result
    }

}

data class SignalInput(
    val signalPatterns: List<String>,
    val outputPatterns: List<String>
)

