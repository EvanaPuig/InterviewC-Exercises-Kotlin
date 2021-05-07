package ch6RecursionAndBacktracking.auxiliaryBuffer

/*
Question 30

Level: Medium

Statement: Print all subsets of an array of integers.
    For example:
        Input: [1, 2, 3]
        Output:
        []
        [1]
        [2]
        [3]
        [1, 2]
        [1, 3]
        [2, 3]
        [1, 2, 3]

 Questions to Clarify:
	Q. Do we print out the empty set?
	A. Yes

	Q. Can we assume there are no duplicates?
	A. Yes

	Q. If the input is an empty array, do we just print out the empty set?
	A. Yes

	Q. If the input is null, should we throw an exception of simply print nothing?
	A. Let’s just print nothing.
 */

class SubsetsOfArray {
    /*
    Complexity
        Time Complexity: Factorial Complexity

        Note: Typically, interviewers will not ask the time complexity of such complex recursions.

        However, if you’re still interested, the complexity is described in the “find combinations” problem above.

        Space Complexity: O(N), where N is A’s length. We use O(N) space both in the buffer allocation and on the recursion stack.
     */

    fun printSubsets(a: Array<Int>?) {
        if(a.isNullOrEmpty())
            return

        val buffer = arrayOfNulls<Int>(a.size)
        printSubsetsHelper(a, buffer, 0, 0)
    }

    private fun printSubsetsHelper(a: Array<Int>, buffer: Array<Int?>, startIndex: Int, bufferIndex: Int){
        printArray(buffer, bufferIndex)
        // termination cases - buffer full
        if (bufferIndex == buffer.size) {
            return
        }
        if (startIndex == a.size)
            return

        // find candidates that go into current buffer index
        for (i in startIndex until a.size) {
            // place item into buffer
            buffer[bufferIndex] = a[i]

            // recurse to next buffer index
            printSubsetsHelper(a, buffer, i+1, bufferIndex + 1)
        }
    }

    private fun printArray(buffer: Array<Int?>, bufferIndex: Int) {
        println()
        for (i in 0 until bufferIndex) {
            if (buffer[i] != null)
                println("${buffer[i]}")
        }
    }
}

fun main() {
    /*
    Test Cases:
        Edge Cases: A is empty/null
        Base Cases: A is of size 1 and 2
        Regular Cases: A is of size greater than 2
     */

    val instance = SubsetsOfArray()

    // Edge Cases:
    // 1. Empty Array
    println("Empty array: ${instance.printSubsets(arrayOf())}")

    // 2. Null Array
    println("Null array: ${instance.printSubsets(null)}")

    // Base cases:
    // 5. A of size 1
    println("A of size 1: ${instance.printSubsets(arrayOf(5))}")

    // 6. A of size 2
    println("A of size 2: ${instance.printSubsets(arrayOf(5, 6))}")

    // Regular Cases:
    // 8. A of any size greater than 2
    println("X < a.length: ${instance.printSubsets(arrayOf(1, 2, 3, 4, 5, 6, 7))}")

}