![](https://img.shields.io/static/v1?label=%F0%9F%93%85%20Completed%20Days&message=20&color=blue&style=flat-square)
![](https://img.shields.io/static/v1?label=%E2%AD%90%20Gained%20Stars&message=40&color=yellow&style=flat-square)
  
# Advent of Code (2021)
In this repository, I'm about to provide solutions for the Advent of Code[^aoc] puzzles using [Kotlin][kotlin] language.

## Motivation
I decided to do the Advent of Code in Kotlin, as it is my favorite programming language which I use way to infrequently. I'm only
able to use them in my side projects and unfortunately not in my professional career at my current employer.  
I use this event to get a broader knowledge about the Kotlin standard library.

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

| #   | Name                          | Stars | Comment                                                                                                                                                                                                              |  
|-----|-------------------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | [Sonar Sweep][1]              | ⭐⭐    | Did a very basic/unimproved implementation that did the job. No performance improvements needed to calculate solutions.<br/>_Edit: Did improvement using [windowed()][windowed] function._                           |
| 2   | [Dive!][2]                    | ⭐⭐    | Did not see the challenge in this puzzle. Straight forward implementation did the job.                                                                                                                               |
| 3   | [Binary Diagnostic][3]        | ⭐⭐    | Can't really estimate the quality of the solution, but it looks a bit bloated. Guess there is a more elegant way to solve this puzzle.                                                                               |
| 4   | [Giant Squid][4]              | ⭐⭐    | Implemented an object-oriented solution. Instead of a 2d-array I used a simple list for the board.                                                                                                                   |
| 5   | [Hydrothermal Venture][5]     | ⭐⭐    | Implemented an object-oriented solution again. Already guessed the part 2 of the puzzle, so diagonals were supported right from the beginning.                                                                       |
| 6   | [Lanternfish][6]              | ⭐⭐    | Part 1 was straight forward (5 min). Performance was so bad that I had to completely redo it for part 2. But now I'm pretty proud on the solution, as it is simple and fast.                                         |
| 7   | [The Treachery of Whales][7]  | ⭐⭐    | Was pretty fast in finding solution for part 1 (5 min). Also for part 2 (10 min), but had issues as the best position isn't always exactly the average of the positions.                                             |
| 8   | [Seven Segment Search][8]     | ⭐⭐    | Can't make any statement about the puzzles level of difficulty, as I had only 3 hours of sleep last night.                                                                                                           |
| 9   | [Smoke Basin][9]              | ⭐⭐    | Added some foolish bugs to the recursion of part 2. This required some time to correct it. Best would have been to start part 2 all over instead of bug fixing it.                                                   |
| 10  | [Syntax Scoring][10]          | ⭐⭐    | Really liked this puzzle. As soon as you see, that the issue is related to stacks, it is a straight forward implementation.                                                                                          |
| 11  | [Dumbo Octopus][11]           | ⭐⭐    | Tried to implement a highly optimized solution from the beginning, but failed. Started all over again and implemented it just as described in the puzzle. Solution was fast enough.                                  |
| 12  | [Passage Pathing][12]         | ⭐⭐    | As I did a route optimization side project (using A* algorithm) this was straight forward. Instead of finding only the optimal route (as in my side project), I just needed to find all routes (which is more easy). |
| 13  | [Transparent Origami][13]     | ⭐⭐    | Had some issues cause I was mixing up horizontal and vertical folding all the time. So had to invest some time in bug fixing.                                                                                        |
| 14  | [Extended Polymerization][14] | ⭐⭐    | Needed to reimplement everything for part 2, as part 1 was very in-performant. This took me a looot of time.                                                                                                         |
| 15  | [Chiton][15]                  | ⭐⭐    | Only needed to do simple adaptations on solution of part 1 to be able to process part 2 in time. But I did a dumb error when calculation neighbours of current field which cost me about 2 hours to find.            |
| 16  | [Packet Decoder][16]          | ⭐⭐    | Really liked the topic this puzzle. Also the implementation went pretty smooth.I had only some minor bugs that were found during testing using the given samples.                                                    |
| 17  | [Trick Shot][17]              | ⭐⭐    | This puzzle took me a long time, as I tried to implement it iteratively. When doing the maths using pen and paper it was solved pretty fast. Especially part 1 is bad code but great maths.                          |
| 18  | [Snailfish][18]               | ⭐⭐    | I'm not quite happy with my solution, as the code is not very easy to understand. Maybe even the way I implemented the recursion can be improved.                                                                    |
| 19  | [Beacon Scanner][19]          | ⭐⭐    | I guess my solution is the brute force way. It takes about 20 seconds to solve one of the parts. There has to be a better/more elegant way, but I was not able to find it.                                           |
| 20  | [Trench Map][21]              | ⭐⭐    | This puzzle was more easy compared to the previous ones. Only applying the filter to the infinite surrounding pixels was a bit tricky.                                                                               |
| 21  |                               |       |                                                                                                                                                                                                                      |
| 22  |                               |       |                                                                                                                                                                                                                      |
| 23  |                               |       |                                                                                                                                                                                                                      |
| 24  |                               |       |                                                                                                                                                                                                                      |
| 25  |                               |       |                                                                                                                                                                                                                      |

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
