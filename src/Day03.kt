
fun main() {
    fun part1(input: List<String>): Int {
        if(input.isEmpty()) return 0

        val counters = IntArray(input[0].length)
        input.forEach {
            it.forEachIndexed { index, c ->
                if(c == '1') counters[index] += 1
            }
        }

        val majority = input.size / 2
        var gammaRate = ""
        var epsilonRate = ""
        counters.forEach {
            if(it > majority) {
                gammaRate += "1"
                epsilonRate += "0"
            } else {
                gammaRate += "0"
                epsilonRate += "1"
            }
        }
        return Integer.parseInt(gammaRate, 2) *
                Integer.parseInt(epsilonRate, 2)
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 0)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
