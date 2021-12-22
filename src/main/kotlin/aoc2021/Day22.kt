package aoc2021

import kotlin.math.abs

object Day22 {

    fun part1(rebootSteps: List<RebootStep>): Long {
        val reactor = Reactor(-50..50, -50..50, -50..50)
        rebootSteps.forEach { reactor.apply(it) }
        return reactor.numberOfActivatedCubes
    }

    fun part2(rebootSteps: List<RebootStep>): Long {
        val reactor = Reactor()
        rebootSteps.forEachIndexed { index, step ->
            println("Executing Reboot Step ${index + 1}/${rebootSteps.size}")
            reactor.apply(step)
        }
        return reactor.numberOfActivatedCubes
    }

}

class Reactor(
    xSize: IntRange = Int.MIN_VALUE..Int.MAX_VALUE,
    ySize: IntRange = Int.MIN_VALUE..Int.MAX_VALUE,
    zSize: IntRange = Int.MIN_VALUE..Int.MAX_VALUE
) {
    val numberOfActivatedCubes: Long
        get() = activatedCubesClusters.sumOf {
            it.size
        }

    private val range3D = IntRange3D(xSize, ySize, zSize)
    private var activatedCubesClusters = listOf<IntRange3D>()

    fun apply(rebootStep: RebootStep) {
        if (rebootStep.action == RebootAction.TURN_ON && range3D doesNotContain rebootStep.range3D) return

        val newCubeClusters = activatedCubesClusters.flatMap { it - rebootStep.range3D }.toMutableList()
        if (rebootStep.action == RebootAction.TURN_ON) newCubeClusters += rebootStep.range3D
        activatedCubesClusters = newCubeClusters
    }

}

data class IntRange3D(val xRange: IntRange, val yRange: IntRange, val zRange: IntRange) {

    val size: Long by lazy { xRange.size * yRange.size * zRange.size }

    operator fun minus(other: IntRange3D): List<IntRange3D> {
        if (other == this || other contains this) return emptyList()

        // split this cluster into sub-clusters along the edges of the other cluster
        val xCoordsRanges = getSubRanges(other) { it.xRange }
        val yCoordsRanges = getSubRanges(other) { it.yRange }
        val zCoordsRanges = getSubRanges(other) { it.zRange }
        val resultingClusters = mutableListOf<IntRange3D>()
        for (xCoordRange in xCoordsRanges) {
            for (yCoordRange in yCoordsRanges) {
                for (zCoordRange in zCoordsRanges) {
                    resultingClusters += IntRange3D(xCoordRange, yCoordRange, zCoordRange)
                }
            }
        }

        // only keep the clusters which are not contained by the other cluster
        return resultingClusters.filterNot { other contains it }
    }

    private fun getSubRanges(
        other: IntRange3D,
        getRange: (IntRange3D) -> IntRange
    ): List<IntRange> {
        val thisRange = getRange(this)
        val otherRange = getRange(other)

        val coordRanges = mutableListOf<IntRange>()
        var previousCoord = thisRange.first
        if ((otherRange.first in thisRange) && (otherRange.first - 1 in thisRange)) {
            coordRanges += previousCoord until otherRange.first
            previousCoord = otherRange.first
        }
        if ((otherRange.last in thisRange) && (otherRange.last + 1 in thisRange)) {
            coordRanges += previousCoord..otherRange.last
            previousCoord = otherRange.last + 1
        }
        coordRanges += previousCoord..thisRange.last
        return coordRanges
    }

    infix fun doesNotIntersect(other: IntRange3D): Boolean = !this.intersects(other)

    infix fun intersects(other: IntRange3D): Boolean {
        return this.xRange intersects other.xRange || this.yRange intersects other.yRange || this.zRange intersects other.zRange
    }

    infix fun doesNotContain(other: IntRange3D): Boolean = !this.contains(other)

    infix fun contains(other: IntRange3D): Boolean {
        return this.xRange contains other.xRange && this.yRange contains other.yRange && this.zRange contains other.zRange
    }

}

data class RebootStep(val action: RebootAction, val xRange: IntRange, val yRange: IntRange, val zRange: IntRange) {
    val range3D = IntRange3D(xRange, yRange, zRange)
}

enum class RebootAction {
    TURN_ON, TURN_OFF
}


////////////////////////////////////////////////////////////////////////////////////////////
// EXTENSIONS
////////////////////////////////////////////////////////////////////////////////////////////

private val IntRange.size: Long
    get() = abs(this.last.toLong() - this.first.toLong()) + 1

private infix fun IntRange.intersects(other: IntRange): Boolean {
    return (this.first <= other.first) || (this.last >= other.last)
}

private infix fun IntRange.contains(other: IntRange): Boolean {
    return (this.first <= other.first) && (this.last >= other.last)
}
