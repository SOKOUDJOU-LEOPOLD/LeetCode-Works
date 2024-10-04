# Medium

Imagine you are playing a gravity-based puzzle game that involves clearing obstacles to allow an irregularly-shaped figure to fall to the bottom.

You are given a rectangular matrix board representing the game board, which only contains the following types of cells:
"-" represents an empty cell,
"#" represents an obstacle,
"\*" represents part of the figure.

It is guaranteed that the figure consists of one piece, where all parts are connected by the sides.
Your task is to simulate how the figure should fall, and find the minimum number of obstacles that should be removed to let the figure finally touch the bottom of the board with at least one of its cells.
Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than 0(board. length - board[0]. length) will fit within the execution time limit.

### Example 1

```
for input,
board = [["*", "*", "*"],
         ["#", "*", "*"],
         ["*", "*", "-"],
         ["-", "-", "-"],
         ["-", "#", "#"]]
```

the output should be solution (board) = 2 .

### Example 2

```
for input,
board = [["*", "*", "*"],
         ["-", "*", "*"],
         ["*", "*", "-"],
         ["-", "*", "#"],
         ["-", "#", "#"]]
```

the output should be 1.
