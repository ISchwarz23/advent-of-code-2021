![](https://img.shields.io/static/v1?label=%F0%9F%93%85%20Completed%20Days&message=6&color=blue&style=flat-square)
![](https://img.shields.io/static/v1?label=%E2%AD%90%20Gained%20Stars&message=12&color=yellow&style=flat-square)
  
# Advent of Code (2021)
Welcome to the Advent of Code[^aoc] Kotlin project created by [ischwarz23][github] using the [Advent of Code Kotlin Template][template] delivered by JetBrains.

In this repository, I'm about to provide solutions for the puzzles using [Kotlin][kotlin] language.

## Log of my AoC Journey
I tried to write down a comment for each puzzle after solving it. This is the result.

| #   | Name                 | Time Spent | Stars | Comment                                                                                                                                                                                    |  
|-----|----------------------|------------|-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | Sonar Sweep          | ~ 10 min   | ⭐⭐    | Did a very basic/unimproved implementation that did the job. No performance improvements needed to calculate solutions.<br/>_Edit: Did improvement using [windowed()][windowed] function._ |
| 2   | Dive!                | ~ 10 min   | ⭐⭐    | Did not see the challenge in this puzzle. Straight forward implementation did the job.                                                                                                     |
| 3   | Binary Diagnostic    | ~ 15 min   | ⭐⭐    | Can't really estimate the quality of the solution, but it looks a bit bloated. Guess there is a more elegant way to solve this puzzle.                                                     |
| 4   | Giant Squid          | ~ 20 min   | ⭐⭐    | Implemented an object-oriented solution. Instead of a 2d-array I used a simple list for the board.                                                                                         |
| 5   | Hydrothermal Venture | ~ 20 min   | ⭐⭐    | Implemented an object-oriented solution again. Already guessed the part 2 of the puzzle, so diagonals were supported right from the beginning.                                             |
| 6   | Lanternfish          | ~ 30 min   | ⭐⭐    | Part 1 was straight forward (5 min). Performance was so bad that I had to completely redo it for part 2. But now I'm pretty proud on the solution, as it is simple and fast.               |
| 7   |                      |            |       |                                                                                                                                                                                            |
| 8   |                      |            |       |                                                                                                                                                                                            |
| 9   |                      |            |       |                                                                                                                                                                                            |
| 10  |                      |            |       |                                                                                                                                                                                            |
| 11  |                      |            |       |                                                                                                                                                                                            |
| 12  |                      |            |       |                                                                                                                                                                                            |
| 13  |                      |            |       |                                                                                                                                                                                            |
| 14  |                      |            |       |                                                                                                                                                                                            |
| 15  |                      |            |       |                                                                                                                                                                                            |
| 16  |                      |            |       |                                                                                                                                                                                            |
| 17  |                      |            |       |                                                                                                                                                                                            |
| 18  |                      |            |       |                                                                                                                                                                                            |
| 19  |                      |            |       |                                                                                                                                                                                            |
| 20  |                      |            |       |                                                                                                                                                                                            |
| 21  |                      |            |       |                                                                                                                                                                                            |
| 22  |                      |            |       |                                                                                                                                                                                            |
| 23  |                      |            |       |                                                                                                                                                                                            |
| 24  |                      |            |       |                                                                                                                                                                                            |
| 25  |                      |            |       |                                                                                                                                                                                            |

[^aoc]:
    [Advent of Code][aoc] – an annual event in December since 2015.
    Every year since then, with the first day of December, a programming puzzles contest is published every day for twenty-four days.
    A set of Christmas-oriented challenges provide any input you have to use to answer using the language of your choice.

[aoc]: https://adventofcode.com
[docs]: https://kotlinlang.org/docs/home.html
[github]: https://github.com/ischwarz23
[issues]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template/issues
[kotlin]: https://kotlinlang.org
[template]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template
[windowed]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/windowed.html
