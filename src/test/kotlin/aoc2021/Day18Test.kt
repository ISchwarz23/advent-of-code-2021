package aoc2021

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day18Test {

    private val testInput = readInput("Day18_test")
    private val input = readInput("Day18")

    @Test
    internal fun testPart1() {
        // when
        val result = Day18.part1(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 18 - Part 1: ${Day18.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day18.part2(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 18 - Part 2: ${Day18.part2(input)}")
    }

}