import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        if (input.isEmpty()) return 0

        val counters = IntArray(input[0].length)
        input.forEach {
            it.forEachIndexed { index, c ->
                if (c == '1') counters[index] += 1
            }
        }

        val majority = input.size / 2
        val maxExponent = input[0].length - 1
        var gammaRate = 0
        var epsilonRate = 0
        counters.forEachIndexed { index, i ->
            val value = 2.pow(maxExponent - index)
            if (i > majority) gammaRate += value else epsilonRate += value
        }
        return gammaRate * epsilonRate
    }

    fun part2(input: List<String>): Int {

        fun count(i: List<String>, c: Char, index: Int): Int {
            return i.count { it.toCharArray()[index] == c }
        }

        fun calculateOxygenGeneratorRating(): Int {
            var inputCopy: List<String> = input.toMutableList()
            var index = 0
            while (inputCopy.size > 1) {
                val countOf1 = count(inputCopy, '1', index)
                inputCopy = if (countOf1 >= inputCopy.size - countOf1) {
                    inputCopy.filter { it.toCharArray()[index] == '1' }
                } else {
                    inputCopy.filter { it.toCharArray()[index] == '0' }
                }
                index++
            }
            return Integer.parseInt(inputCopy[0], 2)
        }

        fun calculateCO2ScrubberRating(): Int {
            var inputCopy: List<String> = input.toMutableList()
            var index = 0
            while (inputCopy.size > 1) {
                val countOf0 = count(inputCopy, '0', index)
                inputCopy = if (countOf0 <= inputCopy.size - countOf0) {
                    inputCopy.filter { it.toCharArray()[index] == '0' }
                } else {
                    inputCopy.filter { it.toCharArray()[index] == '1' }
                }
                index++
            }
            return Integer.parseInt(inputCopy[0], 2)
        }

        return calculateOxygenGeneratorRating() * calculateCO2ScrubberRating()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))  // 3901196
    println(part2(input))  // 4412188
}

private fun Int.pow(exponent: Int): Int {
    return this.toDouble().pow(exponent).toInt()
}