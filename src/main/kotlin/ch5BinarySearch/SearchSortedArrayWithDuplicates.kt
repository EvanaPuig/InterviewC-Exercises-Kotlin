package ch5BinarySearch

/*
Problem 19

Given a sorted array with duplicates, search for the first appearance of a target item.
Level: Easy

Important
First:
Instead of using
mid = (start + end)/2
to calculate the midpoint we use
mid = start + (end - start)/2. This has become a popular question.

Why do we use this?
Let’s say start and end were very large integers. We know they cannot be larger than 2^31 - 1 (~2 billion), because they are given to us as integers (assuming integer size of 32 bytes).
However, their sum could be larger. This is called an integer overflow.

In an integer overflow, start + end would wrap around the max value into the negatives. If it is an unsigned integer, the value would wrap around 0.

### Questions to clarify
	Q. How do you want the output?
	A. Return the index of the target item.

	Q. What do do if target was not found?
	A. Return -1

 */

class SearchSortedArrayWithDuplicates {
    /*
    Time Complexity: O(log(n))
    Remember, log(n) here is base 2, because we are dividing the work by 2 each time.
    Space Complexity: O(1)
     */
    fun findElementInArray(a: Array<Int>?, target: Int): Int? {
        if(a.isNullOrEmpty())
            return null

        var start = 0
        var end = a.size - 1

        while(start <= end) {
            val mid = start + (end - start) / 2
            when {
                a[mid] > target || (a[mid] == target && mid > 0 && a[mid - 1] == target) ->
                    end = mid - 1
                a[mid] < target -> start = mid + 1
                else -> return mid
            }
        }
        return null
    }
}

fun main() {
    /*
    Test Cases
    Test Cases:Edge Cases: empty array, null array
    Base Cases: single element, 2 equal elements (target missing/present)
    Regular Cases: only equal elements, no duplicate elements, normal case
     */

    val instance = SearchSortedArrayWithDuplicates()
    var result: Int? = null
    val target = 5

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.findElementInArray(emptyArray, target)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.findElementInArray(nullArray, target)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. Single element which is the target
    val singleElementAboveX = arrayOf(5)
    result = instance.findElementInArray(singleElementAboveX, target)
    println("Base Case: Single Element Array that is target: $result")

    // 4. Single element which is not the target
    val singleElementArrayZero = arrayOf(3)
    result = instance.findElementInArray(singleElementArrayZero, target)
    println("Base Case: Single Element Array that is not the target: $result")

    // 5. Two equal elements with target
    val twoElementsArray = arrayOf(5, 5)
    result = instance.findElementInArray(twoElementsArray, target)
    println("Base Case: Two Elements Array: $result")

    // 6. Two equal elements without target
    val twoElementsArrayNoTarget = arrayOf(2, 2)
    result = instance.findElementInArray(twoElementsArrayNoTarget, target)
    println("Base Case: Two elements without target: $result")

    // Regular cases
    // 7. Only Equal elements with target
    val standardCase = arrayOf(5, 5, 5, 5)
    result = instance.findElementInArray(standardCase, target)
    println("Regular Case: Only equal elements with target: $result")

    // 8. Only Equal elements without target
    val standardCaseWithout = arrayOf(2, 2, 2, 2)
    result = instance.findElementInArray(standardCaseWithout, target)
    println("Regular Case: Only equal elements without target: $result")

    // 8. Many elements without target
    val standardCaseWithoutTarget = arrayOf(1, 2, 3, 4, 6)
    result = instance.findElementInArray(standardCaseWithoutTarget, target)
    println("Regular Case: Standard Case without target: $result")

    // 9. Many elements with target
    val standardCaseWithTarget = arrayOf(1, 2, 3, 4, 5, 7, 7)
    result = instance.findElementInArray(standardCaseWithTarget, target)
    println("Regular Case: Standard Case without target: $result")
}