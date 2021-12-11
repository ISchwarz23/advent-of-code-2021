package aoc2021

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day12Test {

    private val testInput = readInput("Day12_test")
    private val input = readInput("Day12")

    @Test
    internal fun testPart1() {
        // when
        val result = Day12.part1(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 12 - Part 1: ${Day12.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day12.part2(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 12 - Part 2: ${Day12.part2(input)}")
    }

}