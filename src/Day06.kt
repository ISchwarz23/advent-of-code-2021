fun main() {

    // 3,4,3,1,2
    fun part1(input: List<Int>): Int {
        var fishAges: MutableList<Int> = input.toMutableList()
        for(i in 0 until 80) {
            val fishToAdd = fishAges.count { it == 0 }
            fishAges = fishAges.map { if(it > 0) it - 1 else 6 }.toMutableList()
            for(n in 0 until fishToAdd) fishAges.add( 8 )
        }
        return fishAges.size
    }

    fun part2(input: List<Int>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readOneLineInputAsInts("Day06_test")
    check(part1(testInput) == 5934)
    check(part2(testInput) == 0)

    val input = readOneLineInputAsInts("Day06")
    println(part1(input))
    println(part2(input))
}
