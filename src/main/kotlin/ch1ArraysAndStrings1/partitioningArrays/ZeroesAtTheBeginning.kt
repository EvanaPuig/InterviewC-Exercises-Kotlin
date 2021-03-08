package ch1ArraysAndStrings1.partitioningArrays

/*
Statement: You are given an array of integers. Rearrange the array so that all zeroes are at the beginning of the array.
For example, [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
Level: Easy

Questions to Clarify:
Q. What if there are no zeroes?
A. Then the array will be unchanged.

Q. After the re-arrangement, do non-zero elements need to be in the same order as they were before?
A. No, they need not be in the same order.
 */

class ZeroesAtTheBeginning {
    /*
    Time Complexity O(n)
    Space Complexity O(n)
     */
    fun moveZeroesToBeginningBruteForce(a: Array<Int>?): Array<Int>? {
        if(a.isNullOrEmpty())
            return a

        val resultArray = mutableListOf<Int>()
        var index = 0

        for (item in a) {
            if (item == 0) {
                resultArray.add(index, item)
                index++
            }
        }

        for (item in a) {
            if (item != 0) {
                resultArray.add(index, item)
                index++
            }
        }

        return resultArray.toTypedArray()
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun moveZeroesToBeginningPartitioning(a: Array<Int>?): Array<Int>? {
        if (a.isNullOrEmpty())
            return a

        var boundary = 0

        for (i in a.indices) {
            if(a[i] == 0) {
                swap(a, i, boundary)
                boundary++
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
    Edge Cases: Empty array, null array
    Base Cases: one element (zero/non-zero)
    Regular Cases: All zeroes, all non-zeroes, mix of zeroes and non-zeroes
     */
    val instance = ZeroesAtTheBeginning()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.moveZeroesToBeginningBruteForce(emptyArray)
    println("Empty array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.moveZeroesToBeginningBruteForce(nullArray)
    println("Null array: ${result?.joinToString(", ")}")

    // 3. Array with one element that is not a zero
    val singleElementArrayNotZero = arrayOf(5)
    result = instance.moveZeroesToBeginningBruteForce(singleElementArrayNotZero)
    println("Single array not zero: ${result?.joinToString(", ")}")

    // 3. Array with one element that is a zero
    val singleElementArrayZero = arrayOf(0)
    result = instance.moveZeroesToBeginningBruteForce(singleElementArrayZero)
    println("Single array zero: ${result?.joinToString(", ")}")

    // 4. Array with only zeroes
    val arrayAllZeroes = arrayOf(0, 0, 0, 0, 0)
    result = instance.moveZeroesToBeginningBruteForce(arrayAllZeroes)
    println("Array all zeroes: ${result?.joinToString(", ")}")

    // 5. Array with no zeroes
    val arrayNoZeroes = arrayOf(5, 5, 3, 2, 4, 1)
    result = instance.moveZeroesToBeginningBruteForce(arrayNoZeroes)
    println("Array no zeroes: ${result?.joinToString(", ")}")

    // 6. Array with many elements and some zeroes
    val normalArray = arrayOf(1, 1, 2, 0, 3, 0, 7, 0)
    result = instance.moveZeroesToBeginningBruteForce(normalArray)
    println("Regular Case: ${result?.joinToString(", ")}")

    // Corner Cases:
    // 1. Empty array
    result = instance.moveZeroesToBeginningPartitioning(emptyArray)
    println("Empty array: ${result?.joinToString(", ")}")

    // 2. Null array
    result = instance.moveZeroesToBeginningPartitioning(nullArray)
    println("Null array: ${result?.joinToString(", ")}")

    // 3. Array with one element that is not a zero
    result = instance.moveZeroesToBeginningPartitioning(singleElementArrayNotZero)
    println("Single array not zero: ${result?.joinToString(", ")}")

    // 3. Array with one element that is a zero
    result = instance.moveZeroesToBeginningPartitioning(singleElementArrayZero)
    println("Single array zero: ${result?.joinToString(", ")}")

    // 4. Array with only zeroes
    result = instance.moveZeroesToBeginningPartitioning(arrayAllZeroes)
    println("Array all zeroes: ${result?.joinToString(", ")}")

    // 5. Array with no zeroes
    result = instance.moveZeroesToBeginningPartitioning(arrayNoZeroes)
    println("Array no zeroes: ${result?.joinToString(", ")}")

    // 6. Array with many elements and some zeroes
    result = instance.moveZeroesToBeginningPartitioning(normalArray)
    println("Regular Case: ${result?.joinToString(", ")}")
}