package ch2SubarrayProblems.slidingWindow

/*
Problem 14

Given an array of positive integers, find a subarray that sums to a given number X.
For e.g, input = [1,2,3,5,2] and X=8, Result = [3,5] (indexes 2,3)
Level: Medium

Questions to Clarify:
    Q. How to return the result?
    A. Return the start and end indices of the subarray.

    Q. What to return if the array is empty or null?
    A. Return null.

    Q. What to return if no subarray is found?
    A. Return null.

    Q. What to do if there are multiple subarrays?
    A. Return any one.
 */

class SubarrayThatSumsToX {
    /*
    Brute Force
    Time complexity: O(n^2)
    Space complexity: O(1)
    */

    /*
    Sliding Window
    Time complexity: O(n)
    Space complexity: O(1)
     */

    fun subarraySum(a: Array<Int>?, x: Int): Pair<Int, Int>? {
        if (a.isNullOrEmpty())
            return null

        var start = 0
        var end = 0
        var sum = a[0]
        while(start < a.size) {
            if (start < end) {
                end = start
                sum = a[start]
            }
            if (sum < x) {
                if (end == a.size - 1)
                    break
                end++
                sum += a[end]
            } else if (sum > x) {
                sum -= a[start]
                start++
            } else {
                return Pair(start, end)
            }
        }
        return null
    }
}

fun main() {
    /*
    Test Cases
    Edge Cases: empty array, null array
    Base Cases: single element (more/less/equal to X)
    Regular Cases: two elements, no sum equals to X, etc.
     */

    val instance = SubarrayThatSumsToX()
    var result: Pair<Int, Int>? = null
    val x = 5

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.subarraySum(emptyArray, x)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.subarraySum(nullArray, x)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. single element (above X)
    val singleElementAboveX = arrayOf(6)
    result = instance.subarraySum(singleElementAboveX, x)
    println("Base Case: Single Element Array above X: $result")

    // 4. single element (below X)
    val singleElementArrayZero = arrayOf(3)
    result = instance.subarraySum(singleElementArrayZero, x)
    println("Base Case: Single Element Array below X: $result")

    // 5. single element (equal to X)
    val singleElementArrayEqualToX = arrayOf(x)
    result = instance.subarraySum(singleElementArrayEqualToX, x)
    println("Base Case: Single Element Array Equal to X: $result")

    // Regular Cases
    // 6. two elements
    val twoElementsArray = arrayOf(2, -3)
    result = instance.subarraySum(twoElementsArray, x)
    println("Base Case: Two Elements Array: $result")

    // 7. no sum equals x
    val noSumEqualsXArray = arrayOf(-2, 3, -1, -8)
    result = instance.subarraySum(noSumEqualsXArray, x)
    println("Regular Case: No Sum equals X: $result")

    // 8. all +ve
    val standardCase = arrayOf(1, 2, 3, 5, 2)
    result = instance.subarraySum(standardCase, x)
    println("Regular Case: Standard Case: $result")

}