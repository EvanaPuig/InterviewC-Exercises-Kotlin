package ch2SubarrayProblems.kadanesAlgorithm

import kotlin.math.max

/*
Question 13

Given an array of integers that can be both +ve and -ve, find the contiguous subarray with the largest sum.
For example: [1,2,-1,2,-3,2,-5] -> first 4 elements have the largest sum. Return (0,3)
Level: Medium

Questions to Clarify:
    Q. How do you want the output?
    A. Return the value of the maximum sum.

    Q. Do empty arrays count as a subarray?
    A. No, the subarray should have at least 1 element.

    Q. But what if the input array is empty or null?
    A. Throw an exception.
 */

class KadanesAlgorithm {
    /*
    Brute force
    Time complexity: O(n^2)
    Space complexity: O(1)
    It is good to mention this approach to the interviewer.
     */

    fun maxSumSubarrayBruteForce(a: Array<Int>?): Int? {
        if (a.isNullOrEmpty())
            return null

        var maxSum = a[0]

        for (i in a.indices) {
            var sum = 0
            for ( j in i until a.size) {
                sum += a[j]
                maxSum = max(maxSum, sum)
            }
        }
        return maxSum
    }

    /*
    Time complexity: O(n)
    Space complexity: O(1)
     */
    fun maxSumSubarrayKadanesAlgorithm(a: Array<Int>?): Int?  {
        if (a.isNullOrEmpty())
            return null

        var maxSum = a[0]
        var maxEndingHere = a[0]

        for (i in 1 until a.size) {
            maxEndingHere = max(maxEndingHere + a[i], a[i])
            maxSum = max(maxSum, maxEndingHere)
        }
        return maxSum
    }
}

fun main() {
    /*
    Test Cases
    Edge Cases: empty array, null array
    Base Cases: single element (+ve, 0, -ve), two elements
    Regular Cases: all -ve, all +ve, mix -ve and +ve, all 0s
     */

    val instance = KadanesAlgorithm()
    var result: Int? = null

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.maxSumSubarrayBruteForce(emptyArray)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.maxSumSubarrayBruteForce(nullArray)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. single element (+ve)
    val singleElementArrayPositive = arrayOf(5)
    result = instance.maxSumSubarrayBruteForce(singleElementArrayPositive)
    println("Base Case: Single Positive Element Array: $result")

    // 4. single element (0)
    val singleElementArrayZero = arrayOf(0)
    result = instance.maxSumSubarrayBruteForce(singleElementArrayZero)
    println("Base Case: Single Zero Array: $result")

    // 5. single element (-ve)
    val singleElementArrayNegative = arrayOf(-5)
    result = instance.maxSumSubarrayBruteForce(singleElementArrayNegative)
    println("Base Case: Single Negative Element Array: $result")

    // 6. two elements
    val twoElementsArray = arrayOf(2, -3)
    result = instance.maxSumSubarrayBruteForce(twoElementsArray)
    println("Base Case: Two Elements Array: $result")

    // Regular Cases
    // 7. all -ve
    val negativeElementsArray = arrayOf(-2, -6, -1, -8)
    result = instance.maxSumSubarrayBruteForce(negativeElementsArray)
    println("Regular Case: Negative Elements Array: $result")

    // 8. all +ve
    val positiveElementsArray = arrayOf(3, 6, 1, 8)
    result = instance.maxSumSubarrayBruteForce(positiveElementsArray)
    println("Regular Case: Positive Elements Array: $result")

    // 9. mix -ve and +ve
    val mixedElementsArray = arrayOf(2, -3, 8, 6, -1)
    result = instance.maxSumSubarrayBruteForce(mixedElementsArray)
    println("Regular Case: Mixed Elements Array: $result")

    // 10. all 0s
    val zeroesArray = arrayOf(0, 0, 0, 0, 0)
    result = instance.maxSumSubarrayBruteForce(zeroesArray)
    println("Regular Case: All zero Elements Array: $result")

    // Corner Cases:
    // 1. Empty array
    result = instance.maxSumSubarrayKadanesAlgorithm(emptyArray)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    result = instance.maxSumSubarrayKadanesAlgorithm(nullArray)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. single element (+ve)
    result = instance.maxSumSubarrayKadanesAlgorithm(singleElementArrayPositive)
    println("Base Case: Single Positive Element Array: $result")

    // 4. single element (0)
    result = instance.maxSumSubarrayKadanesAlgorithm(singleElementArrayZero)
    println("Base Case: Single Zero Array: $result")

    // 5. single element (-ve)
    result = instance.maxSumSubarrayKadanesAlgorithm(singleElementArrayNegative)
    println("Base Case: Single Negative Element Array: $result")

    // 6. two elements
    result = instance.maxSumSubarrayKadanesAlgorithm(twoElementsArray)
    println("Base Case: Two Elements Array: $result")

    // Regular Cases
    // 7. all -ve
    result = instance.maxSumSubarrayKadanesAlgorithm(negativeElementsArray)
    println("Regular Case: Negative Elements Array: $result")

    // 8. all +ve
    result = instance.maxSumSubarrayKadanesAlgorithm(positiveElementsArray)
    println("Regular Case: Positive Elements Array: $result")

    // 9. mix -ve and +ve
    result = instance.maxSumSubarrayKadanesAlgorithm(mixedElementsArray)
    println("Regular Case: Mixed Elements Array: $result")

    // 10. all 0s
    result = instance.maxSumSubarrayKadanesAlgorithm(zeroesArray)
    println("Regular Case: All zero Elements Array: $result")
}