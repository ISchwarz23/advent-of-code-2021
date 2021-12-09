package com.schwarz.aoc

object Day09 {

    fun part1(heightMap: HeightMap): Int {
        return heightMap.getLowPoints().map { it.value }.sumOf { it + 1 }
    }

    fun part2(heightMap: HeightMap): Int {
        return heightMap.getLowPoints()
            .map { getUpwardSteps(it).size }
            .sortedDescending()
            .take(3)
            .fold(1) { first, second -> first * second }
    }

    private fun getUpwardSteps(
        point: HeightMapPoint,
        pointsToAvoid: List<HeightMapPoint> = emptyList()
    ): List<HeightMapPoint> {

        if (point.value >= 9) return emptyList()

        val pointsToVisit = point.neighbours.asList()
            .filterNot { pointsToAvoid.contains(it) }
            .filter { it.value >= point.value }

        val extendedPointsToAvoid = mutableListOf<HeightMapPoint>()
        extendedPointsToAvoid += pointsToAvoid
        extendedPointsToAvoid += point

        val upwardPoints = mutableListOf<HeightMapPoint>()
        upwardPoints += point
        for(neighbourToVisit in pointsToVisit) {
            val points = getUpwardSteps(neighbourToVisit, extendedPointsToAvoid)
            upwardPoints += points
            extendedPointsToAvoid += points
        }
        return upwardPoints.distinct()
    }

}


class HeightMap(private val data: List<List<Int>>) {

    val width: Int = data[0].size
    val height: Int = data.size

    fun getValueAt(x: Int, y: Int): Int {
        return data[y][x]
    }

    fun getLowPoints(): List<HeightMapPoint> {
        val lowPoints = mutableListOf<HeightMapPoint>()
        for (y in 0 until height) {
            for (x in 0 until width) {
                val value = getValueAt(x, y)
                val neighbours = getNeighbours(x, y)
                if (neighbours.containsNoValueSmallerThan(value)) {
                    lowPoints += HeightMapPoint(x, y, this)
                }
            }
        }
        return lowPoints
    }

    fun getNeighbours(x: Int, y: Int): HeightMapNeighbours {
        val neighbours = HeightMapNeighbours()
        if (x - 1 >= 0) neighbours.west = HeightMapPoint(x - 1, y, this)
        if (x + 1 < width) neighbours.east = HeightMapPoint(x + 1, y, this)
        if (y - 1 >= 0) neighbours.north = HeightMapPoint(x, y - 1, this)
        if (y + 1 < height) neighbours.south = HeightMapPoint(x, y + 1, this)
        return neighbours
    }

}

data class HeightMapPoint(val x: Int, val y: Int, private val heightMap: HeightMap) {

    val value: Int
        get() = heightMap.getValueAt(x, y)

    val neighbours: HeightMapNeighbours
        get() = heightMap.getNeighbours(x, y)
}

data class HeightMapNeighbours(
    var north: HeightMapPoint? = null,
    var south: HeightMapPoint? = null,
    var east: HeightMapPoint? = null,
    var west: HeightMapPoint? = null
) {

    fun containsNoValueSmallerThan(value: Int): Boolean = !containsValueSmallerOrEqualTo(value)

    fun containsValueSmallerOrEqualTo(value: Int): Boolean {
        north?.let { if (it.value <= value) return true }
        south?.let { if (it.value <= value) return true }
        east?.let { if (it.value <= value) return true }
        west?.let { if (it.value <= value) return true }
        return false
    }

    fun asList(): List<HeightMapPoint> {
        val neighbourList = mutableListOf<HeightMapPoint>()
        north?.let { neighbourList += it }
        south?.let { neighbourList += it }
        east?.let { neighbourList += it }
        west?.let { neighbourList += it }
        return neighbourList
    }

}
