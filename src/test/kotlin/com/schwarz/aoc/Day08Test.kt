package com.schwarz.aoc

import com.schwarz.aoc.utils.readInput
import org.junit.jupiter.api.*
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day08Test {

    private val testInput = readInput("Day08_test")
    private val input = readInput("Day08")

    @Test
    internal fun testPart1() {
        // when
        val result = Day08.part1(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 08 - Part 1: ${Day08.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day08.part2(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 08 - Part 2: ${Day08.part2(input)}")
    }
}