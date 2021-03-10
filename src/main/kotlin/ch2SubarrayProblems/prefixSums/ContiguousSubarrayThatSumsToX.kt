package ch2SubarrayProblems.prefixSums

import ch2SubarrayProblems.slidingWindow.SubarrayThatSumsToX

/*
Given an array of integers, both -ve and +ve, find a contiguous subarray that sums to a number X.
For example: [2,4,-2,1,-3,5,-3], X = 5 --> Result = [2,4,-2,1]
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

class ContiguousSubarrayThatSumsToX {
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */

    fun targetSumSubarray(a: Array<Int>?, target: Int): Pair<Int, Int>? {
        if (a.isNullOrEmpty())
            return null

        var sum = 0
        val map = hashMapOf<Int, Int>()

        for ( i in a.indices) {
            sum += a[i]

            if (sum == target)
                return Pair(0, i)

            if (map.containsKey(sum - target))
                return Pair(map[sum-target]!!.plus(1), i)

            map[sum] = i
        }
        return null
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: Empty Array, Null array
    Base Cases: single element (-ve, +ve, 0)
    Regular Cases: has sum, does not have sum, has sum at beginning/end/middle
     */

    val instance = ContiguousSubarrayThatSumsToX()
    var result: Pair<Int, Int>? = null
    val x = 5

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.targetSumSubarray(emptyArray, x)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.targetSumSubarray(nullArray, x)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. single element (above X)
    val singleElementAboveX = arrayOf(6)
    result = instance.targetSumSubarray(singleElementAboveX, x)
    println("Base Case: Single Element Array above X: $result")

    // 4. single element (below X)
    val singleElementArrayZero = arrayOf(3)
    result = instance.targetSumSubarray(singleElementArrayZero, x)
    println("Base Case: Single Element Array below X: $result")

    // 5. single element (equal to X)
    val singleElementArrayEqualToX = arrayOf(x)
    result = instance.targetSumSubarray(singleElementArrayEqualToX, x)
    println("Base Case: Single Element Array Equal to X: $result")

    // Regular Cases
    // 6. two elements
    val twoElementsArray = arrayOf(2, -3)
    result = instance.targetSumSubarray(twoElementsArray, x)
    println("Base Case: Two Elements Array: $result")

    // 7. no sum equals x
    val noSumEqualsXArray = arrayOf(-2, 3, -1, -8)
    result = instance.targetSumSubarray(noSumEqualsXArray, x)
    println("Regular Case: No Sum equals X: $result")

    // 8. all +ve
    val standardCase = arrayOf(1, 2, 3, 5, 2)
    result = instance.targetSumSubarray(standardCase, x)
    println("Regular Case: Standard Case: $result")
}