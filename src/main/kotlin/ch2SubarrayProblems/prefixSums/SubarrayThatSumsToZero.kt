package ch2SubarrayProblems.prefixSums

/*
Problem 15

Given an array of integers, both -ve and +ve, find a contiguous subarray that sums to 0.
For example: [2,4,-2,1,-3,5,-3] --> [4,-2,1,-3]

Level: Medium

Questions to Clarify:
    Q. How should I return the output?
    A. Return the starting and ending indices of the subarray.

    Q. What to return if the array is empty or null?
    A. Return null.

    Q. What to return if no subarray is found?
    A. Return null.

    Q. What to do if there are multiple subarrays?
    A. Return any one.
 */

class SubarrayThatSumsToZero {
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */

    fun zeroSumSubarray(a: Array<Int>?): Pair<Int, Int>?{
        if (a.isNullOrEmpty())
            return null

        var sum = 0
        val map = hashMapOf<Int, Int>()

        for (i in a.indices) {
            sum += a[i]
            if (sum == 0)
                return Pair(0, i)

            if (map.containsKey(sum))
                return Pair(map[sum]!!.plus(1), i)
            map[sum] = i
        }
        return null
    }
}

fun main(){
    /*
    Test Cases:
    Edge Cases: Empty Array, Null array
    Base Cases: single element (-ve, +ve, 0)
    Regular Cases: has sum, does not have sum, has sum at beginning/end/middle
     */

    val instance = SubarrayThatSumsToZero()
    var result: Pair<Int, Int>? = null

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.zeroSumSubarray(emptyArray)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.zeroSumSubarray(nullArray)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. single element (+ve)
    val singleElementPositive = arrayOf(5)
    result = instance.zeroSumSubarray(singleElementPositive)
    println("Base Case: Single Element Positive: $result")

    // 4. single element (-ve)
    val singleElementNegative = arrayOf(-2)
    result = instance.zeroSumSubarray(singleElementNegative)
    println("Base Case: Single Element Negative: $result")

    // 5. single element (0)
    val singleElementZero= arrayOf(0)
    result = instance.zeroSumSubarray(singleElementZero)
    println("Base Case: Single Element Zero: $result")

    // Regular Cases
    // 6. has sum
    val hasSumArray = arrayOf(-2, 2)
    result = instance.zeroSumSubarray(hasSumArray)
    println("Base Case: Has Sum Array: $result")

    // 7. does not have sum
    val noSumArray = arrayOf(-2, 3, -9, -8)
    result = instance.zeroSumSubarray(noSumArray)
    println("Regular Case: No Sum : $result")

    // 8. has sum at the beginning
    val hasSumBeginningArray = arrayOf(1, -1, 3, 5, 2)
    result = instance.zeroSumSubarray(hasSumBeginningArray)
    println("Regular Case: Sum at the beginning: $result")

    // 9. has sum at the middle
    val hasSumMiddleArray = arrayOf(1, 2, 3, -3, 2, 4)
    result = instance.zeroSumSubarray(hasSumMiddleArray)
    println("Regular Case: Sum at the middle: $result")

    // 10. has sum at the end
    val hasSumEndArray = arrayOf(1, 2, 3, -2, 2)
    result = instance.zeroSumSubarray(hasSumEndArray)
    println("Regular Case: Sum at the end: $result")
}