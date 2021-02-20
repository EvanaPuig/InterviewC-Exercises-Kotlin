package arraysAndStrings1.partitioningArrays

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
    fun moveZeroesToBeginning(a: Array<Int>?): Array<Int>? {
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
    val instance = ZeroesAtTheBeginning()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.moveZeroesToBeginning(emptyArray)
    println("Empty array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.moveZeroesToBeginning(nullArray)
    println("Null array: ${result?.joinToString(", ")}")

    // 3. Array with one element that is not a zero
    val singleElementArrayNotZero = arrayOf(5)
    result = instance.moveZeroesToBeginning(singleElementArrayNotZero)
    println("Single array not zero: ${result?.joinToString(", ")}")

    // 3. Array with one element that is a zero
    val singleElementArrayZero = arrayOf(0)
    result = instance.moveZeroesToBeginning(singleElementArrayZero)
    println("Single array zero: ${result?.joinToString(", ")}")

    // 4. Array with only zeroes
    val arrayAllZeroes = arrayOf(0, 0, 0, 0, 0)
    result = instance.moveZeroesToBeginning(arrayAllZeroes)
    println("Array all zeroes: ${result?.joinToString(", ")}")

    // 5. Array with no zeroes
    val arrayNoZeroes = arrayOf(5, 5, 3, 2, 4, 1)
    result = instance.moveZeroesToBeginning(arrayNoZeroes)
    println("Array no zeroes: ${result?.joinToString(", ")}")

    // 6. Array with many elements and some zeroes
    val normalArray = arrayOf(1, 1, 2, 0, 3, 0, 7, 0)
    result = instance.moveZeroesToBeginning(normalArray)
    println("Regular Case: ${result?.joinToString(", ")}")
}