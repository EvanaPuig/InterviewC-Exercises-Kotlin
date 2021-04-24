package ch1ArraysAndStrings1.partitioningArrays

/*
Question 8

Statement: given an array of integers. Rearrange the array so that all zeroes are at the end of the array.
For example, [4,2,0,1,0,3,0] -> [4,1,2,3,0,0,0]
Level: Easy

Questions to Clarify:
Q. Does it matter what order we place the non-zero numbers?
A. No, you can place them in any order.

Q. What if there are no zeroes?
A. Keep the array as it is.
 */

class ZeroesAtTheEnd {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    fun moveZeroesToEnd(a: Array<Int>?): Array<Int>? {
        if (a.isNullOrEmpty())
            return a

        var boundary = a.size - 1

        for (i in (a.size - 1) downTo 0) {
            if (a[i] == 0) {
                swap(a, i, boundary)
                boundary--
            }
        }

        return a
    }

    private fun swap(a: Array<Int>, elem1: Int, elem2: Int) {
        val temp = a[elem1]
        a[elem1] = a[elem2]
        a[elem2] = temp
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: empty array, null array
    Base Cases: single element (0/non-0), 2 elements
    Regular Cases: more than 2 elements, 0 already at end, etc.
     */
    val instance = ZeroesAtTheEnd()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.moveZeroesToEnd(emptyArray)
    println("Empty array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.moveZeroesToEnd(nullArray)
    println("Null array: ${result?.joinToString(", ")}")

    // 3. Array with one element that is not a zero
    val singleElementArrayNotZero = arrayOf(5)
    result = instance.moveZeroesToEnd(singleElementArrayNotZero)
    println("Single array not zero: ${result?.joinToString(", ")}")

    // 3. Array with one element that is a zero
    val singleElementArrayZero = arrayOf(0)
    result = instance.moveZeroesToEnd(singleElementArrayZero)
    println("Single array zero: ${result?.joinToString(", ")}")

    // 4. Array with only zeroes
    val arrayAllZeroes = arrayOf(0, 0, 0, 0, 0)
    result = instance.moveZeroesToEnd(arrayAllZeroes)
    println("Array all zeroes: ${result?.joinToString(", ")}")

    // 5. Array with no zeroes
    val arrayNoZeroes = arrayOf(5, 5, 3, 2, 4, 1)
    result = instance.moveZeroesToEnd(arrayNoZeroes)
    println("Array no zeroes: ${result?.joinToString(", ")}")

    // 6. Array with many elements including zeroes
    val normalArray = arrayOf(1, 1, 2, 0, 3, 0, 7, 0)
    result = instance.moveZeroesToEnd(normalArray)
    println("Regular Case: ${result?.joinToString(", ")}")
}