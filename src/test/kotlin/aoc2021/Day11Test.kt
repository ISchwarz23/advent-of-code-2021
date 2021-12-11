package aoc2021

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day11Test {

    private val testInput = readInputAsOctopusFiled("Day11_test")
    private val input = readInputAsOctopusFiled("Day11")

    @Test
    internal fun testPart1() {
        // when
        val result = Day11.part1(testInput)

        // then
        assertEquals(1656, result)

        // get solution
        println("Result of Day 11 - Part 1: ${Day11.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day11.part2(testInput)

        // then
        assertEquals(195, result)

        // get solution
        println("Result of Day 11 - Part 2: ${Day11.part2(input)}")
    }

    private fun readInputAsOctopusFiled(name: String): OctopusField {
        val data = readInput(name).map { it.toCharArray().map { c -> c.digitToInt() } }
        return OctopusField(data)
    }

}