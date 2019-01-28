# Chess problem Resolver
To run just execute ``` sbt run``` to get results

## Chess Problem
The problem is to find all unique configurations of a set of normal chess pieces on a chess board with dimensions M×N where none of the pieces is in a position to take any of the others. Assume the colour of the piece does not matter, and that there are no pawns among the pieces.
Write a program which takes as input:
- The dimensions of the board: M, N.
- The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try
and place on the board.

As output, the program should list all the unique configurations to the console for which all of the pieces can be placed on the board without threatening each other.
When returning your solution, please provide with your answer the total number of unique configurations for a **7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight**.

Sample result:
```
   |  a|  b|  c|  d|  e|  f|  g|
---+---+---+---+---+---+---+---+
  1| K | . | . | . | B | . | . |
---+---+---+---+---+---+---+---+
  2| . | . | Q | . | . | . | . |
---+---+---+---+---+---+---+---+
  3| K | . | . | . | . |   | . |
---+---+---+---+---+---+---+---+
  4| . | . | . | . | . | N | N |
---+---+---+---+---+---+---+---+
  5| . | Q | . | . | . | . | . |
---+---+---+---+---+---+---+---+
  6| . | . | . | R | . | . | . |
---+---+---+---+---+---+---+---+
  7| B | . | . | . | N |   |   |
---+---+---+---+---+---+---+---+

K - King
Q - Queen
B - Bishop
R - Rook
N - Knight
. - space occupied by at least one of the pieces
```
