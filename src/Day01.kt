
fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count{ it[0] < it[1] }
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(4).count{ it[0] < it[3] }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInts("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2(input))
}
