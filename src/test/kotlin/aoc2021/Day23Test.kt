package aoc2021

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import utils.readInput
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@TestMethodOrder(
    MethodOrderer.Alphanumeric::class
)
internal class Day23Test {

    private val part1TestInput = readInputAsFloorLayoutAndAmphipodLocations("Day23_Part1_test")
    private val part1Input = readInputAsFloorLayoutAndAmphipodLocations("Day23_Part1")
    private val part2TestInput = readInputAsFloorLayoutAndAmphipodLocations("Day23_Part2_test")
    private val part2Input = readInputAsFloorLayoutAndAmphipodLocations("Day23_Part2")

    @Test
    internal fun testPart1() {
        // when
        println(RoomSwitchingStep(part1TestInput.first, AmphipodLocations(part1TestInput.second), 0))
        val result = Day23.part1(part1TestInput.first, part1TestInput.second)

        // then
        assertEquals(12521, result)

        // get solution
        println(RoomSwitchingStep(part1Input.first, AmphipodLocations(part1Input.second), 0))
        println("Result of Day 23 - Part 1: ${Day23.part1(part1Input.first, part1Input.second)}")
    }

    @Test
    @Ignore("Not fast enough")
    internal fun testPart2() {
        // when
        val result = Day23.part2(part2TestInput.first, part2TestInput.second)

        // then
        assertEquals(44169, result)

        // get solution
        println("Result of Day 23 - Part 2: ${Day23.part2(part2Input.first, part2Input.second)}")
    }

    private fun readInputAsFloorLayoutAndAmphipodLocations(name: String): Pair<FloorLayout, Map<Amphipod, Space>> {
        val floorLayout = FloorLayout()
        val amphipodLocations = mutableMapOf<Amphipod, Space>()

        val lines = readInput(name)

        fun canStopHere(x: Int, y: Int): Boolean {
            return lines[y + 1][x] == '#'
        }

        var notAddedYet: Space? = null
        fun addSpaceToLayout(space: Space) {
            val spaceToLeft = floorLayout.getSpaceAt(space.x - 1, space.y)
            if (spaceToLeft != null) {
                floorLayout.addConnectedSpaces(spaceToLeft, space)
            } else {
                val spaceAbove = floorLayout.getSpaceAt(space.x, space.y - 1)
                if (spaceAbove != null) {
                    floorLayout.addConnectedSpaces(spaceAbove, space)
                } else if (notAddedYet != null) {
                    floorLayout.addConnectedSpaces(notAddedYet!!, space)
                    notAddedYet = null
                } else {
                    notAddedYet = space
                }
            }
        }

        for (y in 1 until lines.size) {
            val line = lines[y]
            val lineAsChars = line.toCharArray()
            var target: Char = 'A' - 1
            for (x in 1 until line.length) {
                when (lineAsChars[x]) {
                    '.' -> {
                        val hallwaySpace = HallwaySpace(x - 1, y - 1, floorLayout, canStopHere(x, y))
                        addSpaceToLayout(hallwaySpace)
                    }
                    'A' -> {
                        val roomSpace = RoomSpace(x - 1, y - 1, floorLayout, ++target)
                        addSpaceToLayout(roomSpace)
                        amphipodLocations[Amphipod.Amber()] = roomSpace
                    }
                    'B' -> {
                        val roomSpace = RoomSpace(x - 1, y - 1, floorLayout, ++target)
                        addSpaceToLayout(roomSpace)
                        amphipodLocations[Amphipod.Bronze()] = roomSpace
                    }
                    'C' -> {
                        val roomSpace = RoomSpace(x - 1, y - 1, floorLayout, ++target)
                        addSpaceToLayout(roomSpace)
                        amphipodLocations[Amphipod.Copper()] = roomSpace
                    }
                    'D' -> {
                        val roomSpace = RoomSpace(x - 1, y - 1, floorLayout, ++target)
                        addSpaceToLayout(roomSpace)
                        amphipodLocations[Amphipod.Desert()] = roomSpace
                    }
                }
            }
        }
        return Pair(floorLayout, amphipodLocations)
    }


/* init {
     // part 1 test
     val hallway1 = HallwaySpace(0, 0, part1TestFloorLayout)
     val hallway2 = HallwaySpace(1, 0, part1TestFloorLayout)
     val hallway3 = HallwaySpace(2, 0, part1TestFloorLayout, false)
     val hallway4 = HallwaySpace(3, 0, part1TestFloorLayout)
     val hallway5 = HallwaySpace(4, 0, part1TestFloorLayout, false)
     val hallway6 = HallwaySpace(5, 0, part1TestFloorLayout)
     val hallway7 = HallwaySpace(6, 0, part1TestFloorLayout, false)
     val hallway8 = HallwaySpace(7, 0, part1TestFloorLayout)
     val hallway9 = HallwaySpace(8, 0, part1TestFloorLayout, false)
     val hallway10 = HallwaySpace(9, 0, part1TestFloorLayout)
     val hallway11 = HallwaySpace(10, 0, part1TestFloorLayout)

     val roomA1 = RoomSpace(2, 1, part1TestFloorLayout, 'A')
     val roomA2 = RoomSpace(2, 2, part1TestFloorLayout, 'A')
     val roomB1 = RoomSpace(4, 1, part1TestFloorLayout, 'B')
     val roomB2 = RoomSpace(4, 2, part1TestFloorLayout, 'B')
     val roomC1 = RoomSpace(6, 1, part1TestFloorLayout, 'C')
     val roomC2 = RoomSpace(6, 2, part1TestFloorLayout, 'C')
     val roomD1 = RoomSpace(8, 1, part1TestFloorLayout, 'D')
     val roomD2 = RoomSpace(8, 2, part1TestFloorLayout, 'D')

     part1TestFloorLayout.addConnectedSpaces(hallway1, hallway2)
     part1TestFloorLayout.addConnectedSpaces(hallway2, hallway3)
     part1TestFloorLayout.addConnectedSpaces(hallway3, hallway4)
     part1TestFloorLayout.addConnectedSpaces(hallway4, hallway5)
     part1TestFloorLayout.addConnectedSpaces(hallway5, hallway6)
     part1TestFloorLayout.addConnectedSpaces(hallway6, hallway7)
     part1TestFloorLayout.addConnectedSpaces(hallway7, hallway8)
     part1TestFloorLayout.addConnectedSpaces(hallway8, hallway9)
     part1TestFloorLayout.addConnectedSpaces(hallway9, hallway10)
     part1TestFloorLayout.addConnectedSpaces(hallway10, hallway11)

     part1TestFloorLayout.addConnectedSpaces(hallway3, roomA1)
     part1TestFloorLayout.addConnectedSpaces(roomA1, roomA2)

     part1TestFloorLayout.addConnectedSpaces(hallway5, roomB1)
     part1TestFloorLayout.addConnectedSpaces(roomB1, roomB2)

     part1TestFloorLayout.addConnectedSpaces(hallway7, roomC1)
     part1TestFloorLayout.addConnectedSpaces(roomC1, roomC2)

     part1TestFloorLayout.addConnectedSpaces(hallway9, roomD1)
     part1TestFloorLayout.addConnectedSpaces(roomD1, roomD2)

     part1TestAmphipodLocations[Amphipod.Bronze()] = roomA1
     part1TestAmphipodLocations[Amphipod.Amber()] = roomA2
     part1TestAmphipodLocations[Amphipod.Copper()] = roomB1
     part1TestAmphipodLocations[Amphipod.Desert()] = roomB2
     part1TestAmphipodLocations[Amphipod.Bronze()] = roomC1
     part1TestAmphipodLocations[Amphipod.Copper()] = roomC2
     part1TestAmphipodLocations[Amphipod.Desert()] = roomD1
     part1TestAmphipodLocations[Amphipod.Amber()] = roomD2
 } */

}