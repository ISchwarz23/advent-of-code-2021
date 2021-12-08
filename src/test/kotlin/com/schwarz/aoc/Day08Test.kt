package com.schwarz.aoc

import com.schwarz.aoc.utils.readInput
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day08Test {

    private val testInput = readSignalInput("Day08_test")
    private val input = readSignalInput("Day08")

    @Test
    internal fun testPart1() {
        // when
        val result = Day08.part1(testInput)

        // then
        assertEquals(26, result)

        // get solution
        println("Result of Day 08 - Part 1: ${Day08.part1(input)}")
    }

    @Test
    internal fun testPart2() {
        // when
        val result = Day08.part2(testInput)

        // then
        assertEquals(61229, result)

        // get solution
        println("Result of Day 08 - Part 2: ${Day08.part2(input)}")
    }

    private fun readSignalInput(name: String): List<SignalInput> {
        return readInput(name).map { it.split(" | ") }
            .map { it[0] to it[1] }
            .map { it.first.split(" ") to it.second.split(" ") }
            .map { SignalInput(it.first, it.second) }
    }
}