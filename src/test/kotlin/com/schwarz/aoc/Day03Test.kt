package com.schwarz.aoc

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import com.schwarz.aoc.utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day03Test {

    private val testInput = readInput("Day03_test")
    private val input = readInput("Day03")

    @Test
    internal fun testPart1() {
        // when
        val result = Day03.part1(testInput)

        // then
        assertEquals(198, result)

        // get solution
        println("Result of Day 03 - Part 1: ${Day03.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day03.part2(testInput)

        // then
        assertEquals(230, result)

        // get solution
        println("Result of Day 03 - Part 2: ${Day03.part2(input)}")
    }

}