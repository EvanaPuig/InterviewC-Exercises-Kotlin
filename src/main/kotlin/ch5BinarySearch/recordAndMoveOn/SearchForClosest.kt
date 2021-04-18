package ch5BinarySearch.recordAndMoveOn

import kotlin.math.abs

/*
Problem 20

Given a sorted array of Integers, find the target. If the target is not found, return the element closest to the target.
For example:
A = [1,2,4,5,7,8,9], Target = 6 -> Output Index = 3 or 4 (since both 5 and 7 are equally close)
Level: Easy

Questions to Clarify:
Q. What if there are two elements equally distant from target?
A. Return either one.

Q. How do you want to return the output?
A. Return the index of the closest element.

Q. What to return if array is empty or null?
A. Return -1.
 */


class SearchForClosest {
    /*
    Time Complexity: O(log(n))
    Space Complexity: O(1)
     */
    fun closestElement(a: Array<Int>?, target: Int): Int? {
        if(a.isNullOrEmpty())
            return null

        var low = 0
        var high = a.size - 1
        var result: Int? = null

        while(low <= high) {
            val mid = low + ((high - low) shr 1)
            result = record(a, mid, result, target)
            when {
                a[mid] > target -> high = mid - 1
                a[mid] < target -> low = mid + 1
                else -> return mid
            }
        }
        return result
    }

    private fun record(a: Array<Int>, mid: Int, result: Int?, target: Int): Int{
        if (result == null || abs(a[mid] - target) < abs(a[result] - target))
                    return mid

        return result
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: empty array, null array
    Base Cases: single element (equal/not-equal to target)
    Regular Cases: has equal element, no equal element, closer element at end/beginning
     */

    val instance = SearchForClosest()
    var result: Int?
    val target = 5

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.closestElement(emptyArray, target)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.closestElement(nullArray, target)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. Single element which is the target
    val singleElementAboveX = arrayOf(5)
    result = instance.closestElement(singleElementAboveX, target)
    println("Base Case: Single Element Array that is target: $result")

    // 4. Single element which is not the target
    val singleElementArrayZero = arrayOf(3)
    result = instance.closestElement(singleElementArrayZero, target)
    println("Base Case: Single Element Array that is not the target: $result")

    // Regular Cases
    // 5. Has equal element
    val twoElementsArray = arrayOf(5, 8)
    result = instance.closestElement(twoElementsArray, target)
    println("Regular Case: Has equal element: $result")

    // 6. No equal element
    val twoElementsArrayNoTarget = arrayOf(-2, -1, 3, 8)
    result = instance.closestElement(twoElementsArrayNoTarget, target)
    println("Regular Case: No equal element: $result")

    // 7. Closer element at the beginning
    val standardCase = arrayOf(4, 7, 10, 11, 13)
    result = instance.closestElement(standardCase, target)
    println("Regular Case: Closer element at the beginning: $result")

    // 8. Closer element at the end
    val standardCaseWithoutTarget = arrayOf(0, 1, 2, 3, 4)
    result = instance.closestElement(standardCaseWithoutTarget, target)
    println("Regular Case: Closer element at the end: $result")
}