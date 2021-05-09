package ch6RecursionAndBacktracking.backtrackingSpaceship

import java.util.*


/*
Question 32

Level: Medium

Statement:
Maze Problem: You are given a 2D array that represents a maze. It can have 2 values - 0 and 1. 1 represents a wall and 0 represents a path.

The objective is to reach the bottom right corner, i.e, A[A.length-1][A.length-1].
You start from A[0][0].
You can move in 4 directions - up, down, left and right.
Find if a path exists to the bottom right of the maze.

For example, a path exists in the following maze:
0111
0111
0000
1110

Questions to Clarify:
	Q. How do you want the output?
	A. Return /true/ if a path exists.

	Q. Does it matter if the end is a path or a wall?
	A. It doesn't matter, the last element ( A[A.length-1][A.length-1] ) can be anything. You just have to get there.

	Q. What if the array is empty or null?
	A. Return false (no path exists).

	Q. What if the array has just one element, e.g, {0} or {1} .
	A. Return true, because we’re already at the last element.
 */

class FindPathIn2DMatrix {
    /*
    TimeComplexity:
    O(4^n ) without memoization, O(n) with memoization, where n is the number of elements in the matrix.

    Without memoization, we do 4 splits every time, and we do that at most n times.
    So the time complexity can be O(4^n)

    With memoization, we process each node only once, so the time complexity is O(n).

    Space Complexity:
    O(n) on both the memo and the recursion stack. Here, n is the number of elements in the matrix.

    Note: If you consider n to be the length of each side of the matrix, the complexity will be expressed as O(n^2).
    Here, we chose n to be the total elements. Both are fine - chose whatever makes sense to you.

    Why does the recursion stack take O(n) space?

    Take the case where the path spirals through the maze:
    we will have roughly n/2 function calls from start to end.

    01000
    01010
    01010
    01010
    00010
     */

    enum class State {
        UNVISITED,
        VISITING,
        NO_PATH_FOUND;
    }
    fun pathExists(a: Array<Array<Int>?>?): Boolean {
        if (a.isNullOrEmpty())
            return false

        val memo = Array(a.size) {
            a[0]?.size?.let { sizeOfColumn ->
                    arrayOfNulls<State>(sizeOfColumn)
            }
        }

        for(states in memo) {
            if (states.isNullOrEmpty()) return false
            Arrays.fill(states, State.UNVISITED)
        }

        return pathExists(a, 0, 0, memo)
    }

    private fun pathExists(a: Array<Array<Int>?>, i: Int, j: Int, memo: Array<Array<State?>?>): Boolean {
        if (objectOutOfBounds(a, i, j) || a[i]!![j] == 1)
            return false

        if (i == a.size - 1 && j == (a[0]?.size?.minus(1))) // end of maze
            return true

        if (memo[i]?.get(j) == State.NO_PATH_FOUND || memo[i]?.get(j) == State.VISITING)
            return false
        memo[i]?.set(j, State.VISITING)

        val points = arrayOf(Pair(i+1, j), Pair(i-1, j), Pair(i, j+1), Pair(i, j-1))

        for (point in points)
            if (pathExists(a, point.first, point.second, memo))
                return true

        memo[i]?.set(j, State.NO_PATH_FOUND)
        return false
    }

    private fun objectOutOfBounds(a: Array<Array<Int>?>, i: Int, j: Int): Boolean {
        return try {
            a[i]!![j]
            false
        } catch (e: IndexOutOfBoundsException) {
            true
        }
    }
}

fun main() {
    /*
    Test Cases:
	    Edge Cases: matrix is empty or null, single element (1 & 0)
	    Base Cases: matrix with 1 row/column
	    Regular Cases: matrix with all walls, matrix with no walls, matrix with/ without path to end, square matrix, rectangular matrix

     */

    val instance = FindPathIn2DMatrix()

    // Edge Cases:
    // 1. Empty Matrix
    println("Empty Matrix: ${instance.pathExists(arrayOf())}")

    // 2. Null Matrix
    println("Null Matrix: ${instance.pathExists(null)}")

    // 3. Single Element '1'
    println("Single Element '1': ${instance.pathExists(arrayOf(arrayOf(1)))}")

    // 4. Single Element '0'
    println("Single Element '0': ${instance.pathExists(arrayOf(arrayOf(0)))}")

    // Base Cases:
    // 5. Matrix with 1 row
    println("Matrix with 1 row with 0s: ${instance.pathExists(arrayOf(arrayOf(0, 0, 0, 0)))}")
    println("Matrix with 1 row with 1s: ${instance.pathExists(arrayOf(arrayOf(1, 1, 1, 1)))}")

    // 6. Matrix with 1 column
    val column: Array<Array<Int>?> = arrayOf(
        arrayOf(1),
        arrayOf(1),
        arrayOf(1)
    )

    println("Matrix with 1 column with 1s: ${instance.pathExists(column)}")

    val column2: Array<Array<Int>?> = arrayOf(
        arrayOf(0),
        arrayOf(0),
        arrayOf(0)
    )

    println("Matrix with 1 column with 0s: ${instance.pathExists(column2)}")

    // Regular Cases:
    // 7. Matrix with all walls
    println("Matrix with all walls: ${instance.pathExists(arrayOf(
        arrayOf(1, 1, 1),
        arrayOf(1, 1, 1),
        arrayOf(1, 1, 1)
    ))}")

    // 8. Matrix with no walls
    println("Matrix with no walls: ${instance.pathExists(arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(0, 0, 0),
        arrayOf(0, 0, 0)
    ))}")

    // 9. Matrix with path to end
    println("Matrix with path to end: ${instance.pathExists(arrayOf(
        arrayOf(0, 1, 1),
        arrayOf(0, 0, 1),
        arrayOf(1, 0, 0)
    ))}")

    // 10. Matrix without path to end
    println("Matrix without path to end: ${instance.pathExists(arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(0, 1, 1),
        arrayOf(1, 0, 0)
    ))}")

    // 11. Square Matrix
    println("Square Matrix: ${instance.pathExists(arrayOf(
        arrayOf(0, 0, 0, 0),
        arrayOf(1, 1, 1, 0),
        arrayOf(1, 1, 1, 0),
        arrayOf(1, 1, 1, 0)
    ))}")

    // 12. Rectangular matrix
    println("Rectangular matrix: ${instance.pathExists(
        arrayOf(
            arrayOf(0, 0, 1, 1),
            arrayOf(1, 0, 1, 1),
            arrayOf(1, 0, 0, 0)
        )
    )}")
}