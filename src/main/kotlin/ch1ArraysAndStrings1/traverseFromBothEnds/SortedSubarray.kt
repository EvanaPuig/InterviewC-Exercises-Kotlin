package ch1ArraysAndStrings1.traverseFromBothEnds

/*
Question 11

Statement: Given an array of integers, find the continuous subarray, which when sorted, results in the entire array being sorted.
For example: A = [0,2,3,1,8,6,9], result is the subarray [2,3,1,8,6]
Level: Medium

Questions to Clarify:
    Q. How to return the result?
    A. Return the result as a pair of indices.
 */

class SortedSubarray {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    fun sortedSubarrayToSortAllArray(a: Array<Int>?): Pair<Int, Int>? {
        if(a.isNullOrEmpty())
            return null

        var start = 0
        var end = a.size - 1

        // find dip
        for (i in 0 until (a.size - 1) ) {
            if (a[start + 1] < a[start])
                break
            start++
        }

        // no dip found, array is already sorted
        if (start == (a.size - 1))
            return null

        // find bump
        for (j in end downTo 0) {
            if (a[end - 1] > a[end])
                break
            end--
        }

        // find min-max of a[start..end]
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        for (k in start until end) {
            if (a[k] > max)
                max = a[k]
            if (a[k] < min)
                min = a[k]
        }

        //expand start and end outward
        while (start > 0 && a[start - 1] > min)
            start--
        while (end < (a.size - 1) && a[end + 1] < max)
            end++

        return Pair(start, end)
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: empty array, null array
    Base Case: one element, 2 elements (sorted and unsorted)
    Regular Case: array already sorted, unsorted portion at beginning/end etc.
     */

    val instance = SortedSubarray()
    var result: Pair<Int, Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.sortedSubarrayToSortAllArray(emptyArray)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.sortedSubarrayToSortAllArray(nullArray)
    println("Corner Case: Null Array: $result")

    // Base Cases:
    // 3. Array with one element
    val singleElementArray = arrayOf(5)
    result = instance.sortedSubarrayToSortAllArray(singleElementArray)
    println("Base Case: Array with one element: $result")

    // 4. Array with two elements sorted
    val twoElementArraySorted = arrayOf(2, 3)
    result = instance.sortedSubarrayToSortAllArray(twoElementArraySorted)
    println("Base Case: Array with two elements sorted: $result")

    // 5. Array with two elements not sorted
    val twoElementArrayUnsorted = arrayOf(3, 2)
    result = instance.sortedSubarrayToSortAllArray(twoElementArrayUnsorted)
    println("Base Case: Array with two elements not sorted: $result")

    //  Regular cases:
    // 6. Array already Sorted
    val alreadySortedArray = arrayOf(2, 3, 4, 5, 6, 7)
    result = instance.sortedSubarrayToSortAllArray(alreadySortedArray)
    println("Regular Case: Array already sorted: $result")

    // 7. Unsorted portion at the beginning
    val unsortedAtBeginning = arrayOf(3, 2, 4, 5, 6, 7)
    result = instance.sortedSubarrayToSortAllArray(unsortedAtBeginning)
    println("Regular Case: Unsorted portion at beginning: $result")

    // 8. Unsorted portion at the end
    val unsortedAtEnd = arrayOf(1, 2, 3, 4, 8, 6, 5, 7)
    result = instance.sortedSubarrayToSortAllArray(unsortedAtEnd)
    println("Regular Case: Unsorted portion at end: $result")

    // 9. Unsorted portion at the middle
    val unsortedAtMiddle = arrayOf(1, 2, 7, 5, 8, 11, 12)
    result = instance.sortedSubarrayToSortAllArray(unsortedAtMiddle)
    println("Regular Case: Unsorted portion in the middle: $result")
}