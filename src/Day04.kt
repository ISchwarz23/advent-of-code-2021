import java.lang.IllegalArgumentException

fun main() {
    fun parseBoards(input: List<String>): MutableList<Board> {
        val boards = mutableListOf<Board>()
        var boardBuilder = BoardBuilder()
        for (i in 2 until input.size) {
            val inputRow = input[i]
            if (inputRow.isEmpty()) {
                boards.add(boardBuilder.build())
                boardBuilder = BoardBuilder()
            } else {
                boardBuilder.addRow(inputRow.split(" ").filter { it.isNotEmpty() }.map { it.toInt() })
            }
        }
        if (boardBuilder.isNotEmpty()) boards.add(boardBuilder.build())
        return boards
    }

    fun part1(input: List<String>): Int {

        // read input
        val calls = input[0].split(",").map { it.toInt() }
        val boards = parseBoards(input)

        // play the game
        var index = -1
        var finishedBoard: Board?
        var lastCall: Int
        do {
            lastCall = calls[++index]
            boards.forEach{ it.mark(lastCall) }
            finishedBoard = boards.find { it.isFinished() }
        } while(finishedBoard == null)

        return finishedBoard.getUnmarkedFieldValues().sum() * lastCall
    }

    fun part2(input: List<String>): Int {

        // read input
        val calls = input[0].split(",").map { it.toInt() }
        var boards: List<Board> = parseBoards(input)

        // play the game
        var index = -1
        var lastCall: Int
        do {
            lastCall = calls[++index]
            boards.forEach{ it.mark(lastCall) }
            boards = boards.filter { !it.isFinished() }
        } while(boards.size > 1)

        val lastFinishedBoard = boards[0]
        while(lastFinishedBoard.isFinished().not()) {
            lastCall = calls[++index]
            lastFinishedBoard.mark(lastCall)
        }
        return lastFinishedBoard.getUnmarkedFieldValues().sum() * lastCall
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

class BoardBuilder {
    private val fields: MutableList<BoardField> = mutableListOf()
    private var boardSize = -1

    fun addRow(rowValues: List<Int>) {
        if(boardSize < 1) {
            boardSize = rowValues.size
        } else if(boardSize != rowValues.size) {
            throw IllegalArgumentException("Row has wrong length")
        }
        rowValues.forEach {
            fields.add(BoardField(it))
        }
    }

    fun isNotEmpty(): Boolean = fields.isNotEmpty()

    fun build(): Board {
        return Board(boardSize, fields)
    }
}

data class BoardField(val value: Int, var isMarked: Boolean = false)

class Board(private val boardSize: Int, private val fields: List<BoardField>) {

    fun mark(fieldValue: Int) {
        fields.find { it.value == fieldValue }?.isMarked = true
    }

    fun isFinished(): Boolean {
        for(i in 0 until boardSize) {
            if(isRowComplete(i)) return true
            if(isColumnComplete(i)) return true
        }
        return false
    }

    fun getUnmarkedFieldValues(): List<Int> {
        return fields.filter { it.isMarked.not() }.map { it.value }
    }

    override fun toString(): String {
        var s = ""
        fields.forEachIndexed { index, field ->
            if(field.value < 10) s += " "
            if(field.isMarked) s += ANSI_RED_BACKGROUND
            s += field.value
            if(field.isMarked) s += ANSI_RESET
            s += " "
            if((index + 1) % boardSize == 0) s += "\n"
        }
        return s
    }

    private fun isRowComplete(rowIndex: Int): Boolean {
        return fields.subList(rowIndex * boardSize, (rowIndex + 1) * boardSize).all { it.isMarked }
    }

    private fun isColumnComplete(columnIndex: Int): Boolean {
        var index = columnIndex
        while (index < fields.size) {
            if(fields[index].isMarked.not()) return false
            index += boardSize
        }
        return true
    }

}