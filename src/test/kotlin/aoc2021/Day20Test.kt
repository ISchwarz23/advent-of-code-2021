package aoc2021

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day20Test {

    private val testInput = readInput("Day20_test")
    private val input = readInput("Day20")

    @Test
    internal fun testPart1() {
        // when
        val result = Day20.part1(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 20 - Part 1: ${Day20.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day20.part2(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 20 - Part 2: ${Day20.part2(input)}")
    }

}
