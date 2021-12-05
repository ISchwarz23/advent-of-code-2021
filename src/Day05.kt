import kotlin.math.absoluteValue

fun main() {

    fun part1(input: List<String>): Int {
        val lines = input.map { it.split(" -> ") }
            .map {
                val startCoords = it[0].split(",").map { i -> i.toInt() }
                val endCoords = it[1].split(",").map { i -> i.toInt() }
                Line(Coords(startCoords[0], startCoords[1]), Coords(endCoords[0], endCoords[1]))
            }
            .filter { it.isNotDiagonal }

        val diagram = Diagram(1000)
        lines.forEach { diagram.add(it) }
        return diagram.numberOfOverlappingFields
    }

    fun part2(input: List<String>): Int {
        val lines = input.map { it.split(" -> ") }
            .map {
                val startCoords = it[0].split(",").map { i -> i.toInt() }
                val endCoords = it[1].split(",").map { i -> i.toInt() }
                Line(Coords(startCoords[0], startCoords[1]), Coords(endCoords[0], endCoords[1]))
            }

        val diagram = Diagram(1000)
        lines.forEach { diagram.add(it) }
        return diagram.numberOfOverlappingFields
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}

class Diagram(private val size: Int = 10) {
    private val fields = MutableList(size * size) { 0 }

    val numberOfOverlappingFields: Int
        get() = fields.filter { it > 1 }.size

    fun add(line: Line) {
        val deltaX = line.end.x - line.start.x
        val deltaY = line.end.y - line.start.y
        val steps = if (deltaX.absoluteValue > deltaY.absoluteValue) deltaX.absoluteValue else deltaY.absoluteValue
        val stepSizeX: Double = deltaX.toDouble() / steps
        val stepSizeY: Double = deltaY.toDouble() / steps

        for (i in 0..steps) {
            val x = (line.start.x + stepSizeX * i).toInt()
            val y = (line.start.y + stepSizeY * i).toInt()
            markField(x, y)
        }
    }

    private fun markField(x: Int, y: Int) {
        fields[x + size * y] += 1
    }

    override fun toString(): String {
        var s = ""
        for (y in 0 until size) {
            for (x in 0 until size) {
                val value = fields[x + size * y]
                if (value == 0) {
                    s += "."
                } else {
                    s += value
                }
            }
            s += "\n"
        }
        return s
    }
}

data class Line(val start: Coords, val end: Coords) {
    val isHorizontal: Boolean = start.y == end.y
    val isVertical: Boolean = start.x == end.x
    val isNotDiagonal: Boolean = isHorizontal || isVertical
}

data class Coords(val x: Int, val y: Int)