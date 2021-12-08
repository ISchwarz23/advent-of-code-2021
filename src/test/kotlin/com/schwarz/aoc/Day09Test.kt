package com.schwarz.aoc

import com.schwarz.aoc.utils.readInput
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day09Test {

    private val testInput = readInput("Day09_test")
    private val input = readInput("Day09")

    @Test
    internal fun testPart1() {
        // when
        val result = Day09.part1(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 09 - Part 1: ${Day09.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day09.part2(testInput)

        // then
        assertEquals(0, result)

        // get solution
        println("Result of Day 09 - Part 2: ${Day09.part2(input)}")
    }

}