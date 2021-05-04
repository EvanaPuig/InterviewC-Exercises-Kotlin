package ch6RecursionAndBacktracking.auxiliaryBuffer

import ch5BinarySearch.specialTricks.SearchForAPeak
import com.sun.xml.internal.fastinfoset.tools.PrintTable.printArray
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.StringBuilder

/*
Question 27

Level: Medium

 Statement: Given an array of integers, print all combinations of size X.

 Questions to Clarify:
	Q. Can the array have duplicates?
	A. No, you can assume there are no duplicate numbers.

	Q. What to print if X is greater than the size of the array?
	A. Print nothing, as there will be no valid combinations.

	Q. What to print if the array is empty?
	A. Print nothing as there will be no combinations.
 */

class CombinationsOfSizeX {
    /*
    Complexity
        Time Complexity: Exponential complexity, that looks like Factorial Complexity
        Space Complexity: O(x)
     */

    fun printCombos(a: Array<Int>?, x: Int) {
        if(a.isNullOrEmpty() || x > a.size || x == 0)
            return

        val buffer = arrayOfNulls<Int>(x)
        printCombosHelper(a, buffer, 0, 0)
    }

    private fun printCombosHelper(a: Array<Int>, buffer: Array<Int?>, startIndex: Int, bufferIndex: Int){
        // termination cases - buffer full
        if (bufferIndex == buffer.size) {
            printArray(buffer)
            return
        }
        if (startIndex == a.size)
            return

        // find candidates that go into current buffer index
        for (i in startIndex until a.size) {
            // place item into buffer
            buffer[bufferIndex] = a[i]

            // recurse to next buffer index
            printCombosHelper(a, buffer, i+1, bufferIndex + 1)
        }
    }

    private fun printArray(buffer: Array<Int?>) {
        println()
        for (i in buffer) {
            println("$i")
        }
    }
}

fun main() {
    /*
    Test Cases:
        Edge Cases: a is empty/null, X is 0, X is greater than a.length
	    BaseCases: a is of size 1 and 2, X is 1
	    Regular Cases: X is smaller than a.length, X is equal to a.length
     */

    val instance = CombinationsOfSizeX()

    // Edge Cases:
    // 1. Empty Array
    println("Empty array: ${instance.printCombos(arrayOf(), 2)}")

    // 2. Null Array
    println("Null array: ${instance.printCombos(null, 2)}")

    // 3. X = 0
    println("X = 0: ${instance.printCombos(arrayOf(1, 2, 3, 4), 0)}")

    // 4. X > a.length
    println("X > a.length: ${instance.printCombos(arrayOf(1, 2, 3, 4), 8)}")

    // Base cases:
    // 5. A of size 1
    println("A of size 1: ${instance.printCombos(arrayOf(5), 5)}")

    // 6. A of size 2
    println("A of size 2: ${instance.printCombos(arrayOf(5, 6), 2)}")

    // 7. X = 1
    println("X = 1: ${instance.printCombos(arrayOf(1, 2, 3, 4), 1)}")

    // Regular Cases:
    // 8. X < a.length
    println("X < a.length: ${instance.printCombos(arrayOf(1, 2, 3, 4, 5, 6, 7), 2)}")

    // 9. X = a.length
    println("X = a.length: ${instance.printCombos(arrayOf(1, 2), 2)}")

}