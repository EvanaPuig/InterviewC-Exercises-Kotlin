package ch6RecursionAndBacktracking.backtrackingSpaceship


/*
Question 35

Level: Medium

Statement:
Given a Sudoku board, find a solution.
The board can have some squares filled out already.
You have to fill the rest of the squares.

(Rules of Sudoku are as follows:
In each column, row and 3 x 3 square, you cannot have duplicate numbers.
Also, only numbers 1-9 are allowed.)

Questions to Clarify:
	Q. How is the input presented?
	A. You’re given a 2D array that represents the board. Each empty square has a value of 0.

	Q. Will the board be of a fixed size?
	A. Yes, the board will always be 9X9.

	Q. How do you want the output?
	A. Fill up the board with a valid answer.

	Q. What if there is no solution. What do we return?
	A. You can throw an error if no solution is found, i.e, the board is invalid.
 */

class SudokuSolver {
    /*
    Time Complexity: O(9^n), where n is the number of squares on the board.

    Why 9^n ? Because we do at most 9 splits each time, and we do this up to n times (for all n squares).
    In this case, since the board size is fixed, our complexity is technically O(1) since n is constant.

    Space Complexity: O(n), where n is the number of squares on the board.
    We use this space both on the recursion stack and on the index (board checker).
     */

    fun solveSudoku(board: Array<IntArray>?) {
        if (board.isNullOrEmpty())
            return

        val checker = BoardChecker(board)
        val success = solveSudoku(board, 0, 0, checker)
        require(success) { "Board has no solution" }

        for (i in board) {
            for (j in i) {
                print(j)
            }
            println()
        }
    }

    private fun solveSudoku(board: Array<IntArray>, i: Int, j: Int, checker: BoardChecker): Boolean {
        if (i == board.size)
            return true

        val next = nextSquare(i, j)

        if (board[i][j] != 0)
            return solveSudoku(board, next.i(), next.j(), checker)

        for (candidate in 1..9) {
            if (checker.canPlace(i, j, candidate)) {
            // place candidate on square
                checker.place(i, j, candidate)
                board[i][j] = candidate

                if (solveSudoku(board, next.i(), next.j(), checker))
                    return true
                // remove candidate from square
                checker.remove(i, j, candidate)
                board[i][j] = 0
            }
        }
        // no solution found
        return false
    }

    private fun nextSquare(i: Int, j: Int): Pair {
        return if (j == 8)
            Pair(i + 1, 0)
        else
            Pair(i, j + 1)
    }
}

class BoardChecker(board: Array<IntArray>) {
    private var row = Array(9) { BooleanArray(10) }
    private var column = Array(9) { BooleanArray(10) }
    private var box = Array(9) { BooleanArray(10) }

    init {
        // add existing numbers to checker
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                if (board[i][j] != 0) {
                    place(i, j, board[i][j])
                }
            }
        }
    }

    fun canPlace(i: Int, j: Int, number: Int): Boolean {
        if (row[i][number]) return false
        if (column[j][number]) return false
        return !box[boxNumber(i, j)][number]
    }

    fun place(i: Int, j: Int, number: Int): Boolean {
        if (!canPlace(i, j, number)) return false
        row[i][number] = true
        column[j][number] = true
        box[boxNumber(i, j)][number] = true
        return true
    }

    fun remove(i: Int, j: Int, number: Int) {
        row[i][number] = false
        column[j][number] = false
        box[boxNumber(i, j)][number] = false
    }

    private fun boxNumber(i: Int, j: Int): Int {
        // Note: (i/3) * 3 is not the same as i.
        // for int values, i/3 gets reduced to floor(i/3).
        return (i/3)*3 + (j/3)
    }
}

class Pair(var i: Int, private var j: Int) {
    fun i(): Int {
        return i
    }

    fun j(): Int {
        return j
    }
}

fun main() {
    /*
    Test Cases:
	    Edge Cases: empty board, invalid board (no solution possible)
	    Base Cases: board with 1 element provided
	    Regular Cases: normal board with many elements provided
     */

    val instance = SudokuSolver()

    // Edge Cases:
    // 1. Null Board
    println("Null Board: ${instance.solveSudoku(null)}")

    // 2. Empty Board
    println("Empty Board: ${instance.solveSudoku(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )
    )}")

    // 3. Invalid Board
    /*println("Invalid Board: ${instance.solveSudoku(
        arrayOf(
            arrayOf(3, 0, 6, 3, 0, 8, 4, 0, 0),
            arrayOf(5, 3, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
            arrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
            arrayOf(9, 0, 0, 3, 6, 3, 0, 0, 5),
            arrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
            arrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
            arrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
        )
    )}")*/

    // Base Cases:
    // 4. Board with 1 element provided
    println("Board with 1 element provided: ${instance.solveSudoku(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 8, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )
    )}")

    // Regular Cases:
    // 5. Normal board with many elements provided
    println("Normal board with many elements provided: ${instance.solveSudoku(
        arrayOf(
            intArrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
            intArrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
            intArrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
            intArrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
            intArrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
            intArrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
            intArrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
        ))}")
}