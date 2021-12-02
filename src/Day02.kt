
fun main() {
    fun part1(input: List<String>): Int {
        var position = 0
        var depth = 0

        input.map { it.split(" ") }
            .map { it[0] to it[1].toInt() }
            .forEach {
                when(it.first) {
                    "forward" -> position += it.second
                    "down" -> depth += it.second
                    "up" -> depth -= it.second
                }
            }
        return position * depth
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 0)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
