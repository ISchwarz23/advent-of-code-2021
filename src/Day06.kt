fun main() {

    fun part1(input: List<Int>): Int {
        var fishAges: MutableList<Int> = input.toMutableList()
        repeat(80) {
            val numberOfFishToAdd = fishAges.count { it == 0 }
            fishAges = fishAges.map { if(it > 0) it - 1 else 6 }.toMutableList()
            repeat(numberOfFishToAdd) { fishAges.add( 8 ) }
        }
        return fishAges.size
    }

    fun part2(input: List<Int>): Long {
        val fishAges: MutableList<Long> = MutableList(9) { 0 }
        input.forEach { fishAges[it]++ }
        repeat(256) {
            val numberOfFishToAdd = fishAges[0]
            for(i in 0 until 8) {
                fishAges[i] = fishAges[i+1]
            }
            fishAges[6] += numberOfFishToAdd
            fishAges[8] = numberOfFishToAdd
        }
        return fishAges.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readOneLineInputAsInts("Day06_test")
    check(part1(testInput) == 5934)
    check(part2(testInput) == 26984457539)

    val input = readOneLineInputAsInts("Day06")
    println(part1(input))
    println(part2(input))
}
