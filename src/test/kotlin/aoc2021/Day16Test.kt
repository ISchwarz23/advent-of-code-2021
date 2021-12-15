package aoc2021

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day16Test {

    private val testInput = readInput("Day16_test")
    private val input = readInput("Day16")

    @Test
    internal fun testPart1() {
        // when
        val result = Day16.part1(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 16 - Part 1: ${Day16.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day16.part2(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 16 - Part 2: ${Day16.part2(input)}")
    }

}