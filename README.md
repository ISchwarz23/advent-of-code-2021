![](https://img.shields.io/static/v1?label=%F0%9F%93%85%20Completed%20Days&message=10&color=blue&style=flat-square)
![](https://img.shields.io/static/v1?label=%E2%AD%90%20Gained%20Stars&message=16&color=yellow&style=flat-square)
  
# Advent of Code (2021)
In this repository, I'm about to provide solutions for the Advent of Code[^aoc] puzzles using [Kotlin][kotlin] language.

## Repo Structure
For each day/puzzle there is a separate file inside the source folder with the pattern `DayXX` (e.g. `Day01`). This file contains
all the code that was used to solve the puzzle.  
The correctness is checked using a JUnit 5 tests. There is one test file for each day using the name pattern `DayXXTest` (e.g. 
`Day01Test`). These tests use the sample input from the puzzle explanation to check if the code is correct. Thereafter, the 
code is called with the real puzzle input.  
This input data is stored in text files in the project resources. The file name pattern of the input files is `DayXX.txt` 
(e.g. `Day01.txt`). The mentioned sample data is stored in files with the name pattern `DayXX_test.txt` (e.g. `Day01_test.txt`).

## Log of my AoC Journey
I tried to log my results and thoughts for each puzzle after solving it.

| #   | Name                         | Time Spent | Stars | Comment                                                                                                                                                                                    |  
|-----|------------------------------|------------|-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | [Sonar Sweep][1]             | ~ 10 min   | ⭐⭐    | Did a very basic/unimproved implementation that did the job. No performance improvements needed to calculate solutions.<br/>_Edit: Did improvement using [windowed()][windowed] function._ |
| 2   | [Dive!][2]                   | ~ 10 min   | ⭐⭐    | Did not see the challenge in this puzzle. Straight forward implementation did the job.                                                                                                     |
| 3   | [Binary Diagnostic][3]       | ~ 15 min   | ⭐⭐    | Can't really estimate the quality of the solution, but it looks a bit bloated. Guess there is a more elegant way to solve this puzzle.                                                     |
| 4   | [Giant Squid][4]             | ~ 20 min   | ⭐⭐    | Implemented an object-oriented solution. Instead of a 2d-array I used a simple list for the board.                                                                                         |
| 5   | [Hydrothermal Venture][5]    | ~ 20 min   | ⭐⭐    | Implemented an object-oriented solution again. Already guessed the part 2 of the puzzle, so diagonals were supported right from the beginning.                                             |
| 6   | [Lanternfish][6]             | ~ 30 min   | ⭐⭐    | Part 1 was straight forward (5 min). Performance was so bad that I had to completely redo it for part 2. But now I'm pretty proud on the solution, as it is simple and fast.               |
| 7   | [The Treachery of Whales][7] | ~ 40 min   | ⭐⭐    | Was pretty fast in finding solution for part 1 (5 min). Also for part 2 (10 min), but had issues as the best position isn't always exactly the average of the positions.                   |
| 8   | [Seven Segment Search][8]    | ~ 120 min  | ⭐⭐    | Can't make any statement about the puzzles level of difficulty, as I had only 3 hours of sleep last night.                                                                                 |
| 9   | [Smoke Basin][9]             | ~ 120 min  | ⭐⭐    | Added some foolish bugs to the recursion of part 2. This required some time to correct it. Best would have been to start part 2 all over instead of bug fixing it.                         |
| 10  | [Syntax Scoring][10]         | ~ 30 min   | ⭐⭐    | Really liked this puzzle. As soon as you see, that the issue is related to stacks, it is a straight forward implementation.                                                                |
| 11  |                              |            |       |                                                                                                                                                                                            |
| 12  |                              |            |       |                                                                                                                                                                                            |
| 13  |                              |            |       |                                                                                                                                                                                            |
| 14  |                              |            |       |                                                                                                                                                                                            |
| 15  |                              |            |       |                                                                                                                                                                                            |
| 16  |                              |            |       |                                                                                                                                                                                            |
| 17  |                              |            |       |                                                                                                                                                                                            |
| 18  |                              |            |       |                                                                                                                                                                                            |
| 19  |                              |            |       |                                                                                                                                                                                            |
| 20  |                              |            |       |                                                                                                                                                                                            |
| 21  |                              |            |       |                                                                                                                                                                                            |
| 22  |                              |            |       |                                                                                                                                                                                            |
| 23  |                              |            |       |                                                                                                                                                                                            |
| 24  |                              |            |       |                                                                                                                                                                                            |
| 25  |                              |            |       |                                                                                                                                                                                            |

[^aoc]:
    [Advent of Code][aoc] – an annual event in December since 2015.
    Every year since then, with the first day of December, a programming puzzles contest is published every day for twenty-four days.
    A set of Christmas-oriented challenges provide any input you have to use to answer using the language of your choice.

[aoc]: https://adventofcode.com
[kotlin]: https://kotlinlang.org
[windowed]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/windowed.html

[1]: https://adventofcode.com/2021/day/1
[2]: https://adventofcode.com/2021/day/2
[3]: https://adventofcode.com/2021/day/3
[4]: https://adventofcode.com/2021/day/4
[5]: https://adventofcode.com/2021/day/5
[6]: https://adventofcode.com/2021/day/6
[7]: https://adventofcode.com/2021/day/7
[8]: https://adventofcode.com/2021/day/8
[9]: https://adventofcode.com/2021/day/9
[10]: https://adventofcode.com/2021/day/10
[11]: https://adventofcode.com/2021/day/11
[12]: https://adventofcode.com/2021/day/12
[13]: https://adventofcode.com/2021/day/13
[14]: https://adventofcode.com/2021/day/14
[15]: https://adventofcode.com/2021/day/15
[16]: https://adventofcode.com/2021/day/16
[17]: https://adventofcode.com/2021/day/17
[18]: https://adventofcode.com/2021/day/18
[19]: https://adventofcode.com/2021/day/19
[20]: https://adventofcode.com/2021/day/20
[21]: https://adventofcode.com/2021/day/21
[22]: https://adventofcode.com/2021/day/22
[23]: https://adventofcode.com/2021/day/23
[24]: https://adventofcode.com/2021/day/24
[25]: https://adventofcode.com/2021/day/25
