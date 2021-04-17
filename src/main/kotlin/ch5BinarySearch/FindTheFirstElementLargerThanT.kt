package ch5BinarySearch

/*
Problem 23

We can distill this problem to a more concrete version:
“Given an array A and target T, Find the first element larger than T”

This will give us the index where T goes.

We need to take care of the following edge cases:
1. If the input array is empty, return 0
2. If all elements are greater than target, return 0
3. If all elements are less than target, return a.length

 Questions to Clarify:
	Q. Can there be duplicates?
	A. Yes, there can be duplicates.

	Q. If T has duplicates (like in example 3 above), which index do we return?
	A. Return the index after the duplicate elements.

	Q. How do you want to return the output?
	A. Return the index where T will go.

	Q. If the array is empty, should we return 0?
	A. Yes

	Q. What do we return if the array is null?
	A. Return -1

	Q. What do we return if all elements are smaller than T?
	A. Return A.length, because that is where T should go

Note: This same algorithm will also work without duplicates.

 */

class FindTheFirstElementLargerThanT {
    /*
    Time Complexity: O(log(n))
    Space Complexity: O(1)
     */
    fun findInsertionIndex(a: Array<Int>?, target: Int): Int {
        if (a == null)
            return -1

        if (a.isEmpty())
            return 0

        var low = 0
        var high = a.size - 1

        while (low <= high){
            val mid = low + (high - low) / 2
            if (a[mid] <= target) {
                if(mid == a.size - 1)
                    return a.size
                low = mid + 1
            } else {
                if (mid == 0 || a[mid - 1] <= target)
                    return mid
                high = mid - 1
            }
        }
        return -1 // Should not happen, can also throw exception here
    }
}

fun main() {
    /*
    Test Cases:
        Edge Cases: empty array, null array
        Base Cases: single element (equal/not-equal to target)
        Regular Cases: has target (single, multiple), doesn’t have target,
                              all elements are smaller/larger than target
     */

    val instance = FindTheFirstElementLargerThanT()
    var result: Int? = null
    val target = 5

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.findInsertionIndex(emptyArray, target)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.findInsertionIndex(nullArray, target)
    println("Corner Case: Null Array: $result")

    // Base Cases:
    // 3. single element equal to target
    val singleElement = arrayOf(5)
    result = instance.findInsertionIndex(singleElement, target)
    println("Base Case: Single Element Equal to Target: $result")

    // 4. single element not-equal to target
    val singleElementNotEqual = arrayOf(3)
    result = instance.findInsertionIndex(singleElementNotEqual, target)
    println("Base Case: Single Element Not-Equal to Target: $result")

    // Regular Cases:
    // 5. has target single
    val hasTargetOnce = arrayOf(1, 2, 4, 5, 6, 8)
    result = instance.findInsertionIndex(hasTargetOnce, target)
    println("Base Case: Has Target Single: $result")

    // 6. has target multiple
    val hasTargetMultiple = arrayOf(1, 2, 4, 5, 5, 5, 6, 8)
    result = instance.findInsertionIndex(hasTargetMultiple, target)
    println("Base Case: Has Target Multiple: $result")

    // 7. doesn’t have target
    val doesntHaveTarget = arrayOf(1, 2, 4, 6, 8)
    result = instance.findInsertionIndex(doesntHaveTarget, target)
    println("Base Case: Doesn't have target: $result")

    // 8. all elements are smaller than target
    val allSmaller = arrayOf(1, 2, 4)
    result = instance.findInsertionIndex(allSmaller, target)
    println("Base Case: All elements smaller than target: $result")

    // 9. all elements are larger than target
    val allLarger = arrayOf(6, 8, 10, 12)
    result = instance.findInsertionIndex(allLarger, target)
    println("Base Case: All elements larger than target: $result")
}