
fun main() {
    fun part1(input: List<String>): Int {
        var increaseCounter = 0
        var previousValue = Integer.MAX_VALUE

        input.map { it.toInt() }.forEach {
            if(it > previousValue)
                increaseCounter++
            previousValue = it
        }
        return increaseCounter
    }

    fun part2(input: List<String>): Int {
        val intInput: List<Int> = input.map { it.toInt() }
        fun getFrameSum(index: Int): Int {
            return intInput[index - 1] + intInput[index] + intInput[index + 1]
        }

        var increaseCounter = 0
        var previousValue = Integer.MAX_VALUE

        for(i in 1..intInput.size-2) {
            val frameSum = getFrameSum(i)
            if(frameSum > previousValue)
                increaseCounter++
            previousValue = frameSum
        }
        return increaseCounter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
