package ch5BinarySearch.implementation

/*
Question 18

Given a sorted array, search for a target item.
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

class SearchSortedArray {
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
                a[mid] > target -> end = mid - 1
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
    Edge Cases: empty array, null array
    Base Cases: single element which is the target, which is not the target
    Regular Cases: two elements, element doesn't exist, etc.
     */

    val instance = SearchSortedArray()
    var result: Int?
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

    // Regular Cases
    // 5. Two elements with target
    val twoElementsArray = arrayOf(5, 8)
    result = instance.findElementInArray(twoElementsArray, target)
    println("Regular Case: Two Elements Array: $result")

    // 6. Two elements without target
    val twoElementsArrayNoTarget = arrayOf(-2, -1, 3, 8)
    result = instance.findElementInArray(twoElementsArrayNoTarget, target)
    println("Regular Case: Two elements without target: $result")

    // 7. Many elements with target
    val standardCase = arrayOf(1, 2, 3, 5, 2)
    result = instance.findElementInArray(standardCase, target)
    println("Regular Case: Standard Case with target: $result")

    // 8. Many elements without target
    val standardCaseWithoutTarget = arrayOf(1, 2, 3, 4, 6)
    result = instance.findElementInArray(standardCaseWithoutTarget, target)
    println("Regular Case: Standard Case without target: $result")
}