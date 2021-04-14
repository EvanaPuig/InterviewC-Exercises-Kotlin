package ch5BinarySearch

/*
Problem 21

Given a sorted array A that has been rotated in a cycle, find the smallest element of the array in O(log(n)) time. For example,

[1,2,4,5,7,8] rotated by 3 gives us /A = [5,7,8,1,2,4]/ and the smallest number is 1.
[1,2,4,5,7,8] rotated by 1 gives us /A = [8,1,2,4,5,7]/ and the smallest number is 1.

Level: Easy

Questions to Clarify:
	Q. How do you want the input
	A. Return the index of the min item.

	Q.Can the array be rotated by 0 elements? i.e, a normal sorted array?
	A. Yes
 */

class SpecialCasesMinOfRotatedArray {
    /*
    Time Complexity: O(log(n))
    Space Complexity: O(1)
     */

    fun findMinOfRotatedArray(a: Array<Int>?): Int? {
        if(a.isNullOrEmpty())
            return null

        var low = 0
        var high = a.size - 1
        val right = a[a.size - 1]

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                a[mid] <= right && (mid == 0 || a[mid - 1] > a[mid]) -> return mid
                a[mid] > right -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return null
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: empty array, null array
    Base Cases: one element, two elements (rotated by 0 & 1)
    Regular Cases: rotated, not rotated
     */

    val instance = SpecialCasesMinOfRotatedArray()
    var result: Int? = null

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.findMinOfRotatedArray(emptyArray)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.findMinOfRotatedArray(nullArray)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. Single element
    val singleElement = arrayOf(5)
    result = instance.findMinOfRotatedArray(singleElement)
    println("Base Case: Single Element: $result")

    // 4. Two elements rotated by 0
    val twoElementsRotatedZero = arrayOf(3, 4)
    result = instance.findMinOfRotatedArray(twoElementsRotatedZero)
    println("Base Case: Two elements rotated by 0: $result")

    // 5. Two elements rotated by 1
    val twoElementsArray = arrayOf(4, 3)
    result = instance.findMinOfRotatedArray(twoElementsArray)
    println("Base Case:  Two elements rotated by 1: $result")

    // Regular cases
    // 6. Rotated
    val standardCase = arrayOf(7, 8, 1, 2, 3)
    result = instance.findMinOfRotatedArray(standardCase)
    println("Regular Case: rotated: $result")

    // 7. Not rotated
    val standardCaseWithout = arrayOf(1, 2, 3, 4, 5)
    result = instance.findMinOfRotatedArray(standardCaseWithout)
    println("Regular Case: not rotated: $result")
}