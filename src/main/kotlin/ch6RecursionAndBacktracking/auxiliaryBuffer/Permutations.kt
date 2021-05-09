package ch6RecursionAndBacktracking.auxiliaryBuffer

/*
Question 31

Level: Medium

Permutations using auxiliary buffer

Statement: Given an array A, print all permutations of size X.
For example
Input:
A = [1,2,3] X=2

Output:
[1, 2] [1, 3] [2, 1] [2, 3] [3, 1] [3, 2]

Questions to Clarify:
	Q. Can we assume there are no duplicates?
	A. Yes

	Q. If the input is an empty array, do we just print nothing?
	A. Yes

	Q. If the input is null, should we throw an exception of simply print nothing?
	A. Let’s just print nothing.

 */

class Permutations {
    /*
    Complexity
        Time Complexity: Factorial Complexity

        Note: Typically, interviewers will not ask the time complexity of such complex recursions.

        The first level of the recursion tree has /n/ function calls.
        At the second level, each function call spawns /n-1/m ore calls.
        The total number of calls looks as follows:
        n * (n-1) * (n-2) * (n-3) * … * (n-X)

        This is factorial time - you can also write it as ## n!/(n-X-1)!

        Space Complexity: O(N), where N is A.length. We use O(N) space both in the buffer allocation
     */

    fun printPerms(a: Array<Int>?, x: Int) {
        if (a.isNullOrEmpty() || x > a.size) return
        val buffer = arrayOfNulls<Int>(x)
        val isInBuffer = BooleanArray(a.size)
        printPermsHelper(a, buffer, 0, isInBuffer)
    }


    fun printPermsHelper(a: Array<Int>, buffer: Array<Int?>, bufferIndex: Int, isInBuffer: BooleanArray) {

        // 1. Termination case
        if (bufferIndex == buffer.size) {
            printArray(buffer, bufferIndex)
            return
        }

        // 2. Find candidates
        for (i in a.indices) {
            if (!isInBuffer[i]) {
                // 3. Place Candidate into buffer Index
                buffer[bufferIndex] = a[i]
                isInBuffer[i] = true

                // 4. Recurse to next buffer Index
                printPermsHelper(a, buffer, bufferIndex + 1, isInBuffer)
                isInBuffer[i] = false
            }
        }
    }

    private fun printArray(buffer: Array<Int?>, bufferIndex: Int) {

        for (i in 0 until bufferIndex) {
            if (buffer[i] != null)
                print("${buffer[i]}, ")
        }
        println()
    }

}

fun main() {
    /*
    Test Cases
	    Edge Cases: a is empty/null, X is 0, X is greater than a.length
	    Base Cases: a is of size 1 and 2, X is 1
	    Regular Cases: X is smaller than a.length, X is equal to a.length
     */

    val instance = Permutations()

    // Edge Cases:
    // 1. Empty Array
    println("Empty array: ${instance.printPerms(arrayOf(), 5)}")

    // 2. Null Array
    println("Null array: ${instance.printPerms(null, 5)}")

    // 3. X = 0
    println("X = 0: ${instance.printPerms(arrayOf(1, 2, 3), 0)}")

    // 4. X > a.length
    println("X > a.length: ${instance.printPerms(arrayOf(1, 2, 3), 5)}")

    // Base Cases:
    // 5. A is of size 1
    println("A is of size 1: ${instance.printPerms(arrayOf(2), 2)}")

    // 6. A is of size 2
    println("A is of size 2: ${instance.printPerms(arrayOf(2, 3), 2)}")

    // 7. X = 1
    println("X = 1: ${instance.printPerms(arrayOf(1, 2, 3), 1)}")

    // Regular Cases
    // 8. X < a.length
    println("X < a.length: ${instance.printPerms(arrayOf(1, 2, 3, 4, 5), 3)}")

    // 9. X = a.length
    println("X = a.length: ${instance.printPerms(arrayOf(1, 2, 3, 4, 5), 5)}")
}