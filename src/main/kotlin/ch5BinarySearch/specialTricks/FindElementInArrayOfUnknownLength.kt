package ch5BinarySearch.specialTricks

/*
Question 22
You are given an array, but you don’t know the length.
Write a program to find a target element in the array.
Level: Medium

Questions to Clarify:
	Q. What happens if we try to access an index that is out of bounds?
	A. An exception is thrown

	Q. How do you want the output?
	A. Return the index of target.

	Q. What to return if target is not found?
	A. Return -1
 */

class SpecialCasesFindElementInArrayOfUnknownLength {
    /*
    Time Complexity: O(log(n))
    Space Complexity: O(1)
     */

    fun findWithUnknownLength(a: Array<Int>?, target: Int): Int? {
        if (a.isNullOrEmpty())
            return -1

        var high = 1 // 1, 2, 4, 8, 16, 32
        var lastIndex = -1

        // Consider putting a sanity limit here, ex. dont go over 1 million.
        // Discuss with the interviewer
        while(true) {
            try {
                a[high]
            } catch (e: IndexOutOfBoundsException) {
                lastIndex = binarySearchForLastIndex(a, high/2, high)
                break
            }
            high *= 2
        }
        return binarySearchOverRange(a, target, 0, lastIndex)
    }

    private fun binarySearchForLastIndex(a: Array<Int>, low: Int, high: Int): Int {
        var localHigh = high
        var localLow = low
        while (localLow <= localHigh) {
            val mid = localLow + (localHigh - localLow) / 2
            try {
                a[mid]
            } catch (e: ArrayIndexOutOfBoundsException) {
                // mid is out of bounds, go to lower half
                localHigh = mid - 1
                continue
            }

            try {
                a[mid + 1]
            } catch (e: ArrayIndexOutOfBoundsException) {
                // id + 1 is out of bounds, mid is last Index
                return mid
            }

            // both mid and mid+1 are inside array, mid is not last index
            localLow = mid + 1
        }
        return -1 //this subarray does not have the end of the array
    }

    private fun binarySearchOverRange(a: Array<Int>, target: Int, low: Int, high: Int): Int? {
        var localLow = low
        var localHigh = high
        while (localLow <= localHigh) {
            val mid = localLow + (localHigh - localLow) / 2
            when {
                a[mid] == target -> {
                    return mid
                }
                a[mid] < target -> {
                    localLow = mid + 1
                }
                else -> {
                    localHigh = mid - 1
                }
            }
        }
        return -1
    }
}

fun main() {
    /*
    Test Cases:
        Edge Cases: empty array, null array
        Base Cases: single element, two elements
        Regular Cases: power of 2 +- 1 / not a power of 2
    */

    val instance = SpecialCasesFindElementInArrayOfUnknownLength()
    var result: Int? = null
    val target = 5

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.findWithUnknownLength(emptyArray, target)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.findWithUnknownLength(nullArray, target)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. Single Element
    val singleElement = arrayOf(5)
    result = instance.findWithUnknownLength(singleElement, target)
    println("Base Case: Single Element: $result")

    // 4. Two elements
    val twoElements = arrayOf(5, 4)
    result = instance.findWithUnknownLength(twoElements, target)
    println("Base Case: Two elements: $result")

    // Regular Cases:
    // 5. power of 2 +- 1 /
    val powerOfTwo = arrayOf(2, 4, 5, 6)
    result = instance.findWithUnknownLength(powerOfTwo, target)
    println("Base Case: Power of two: $result")

    // 6. not a power of 2
    val notPowerOfTwo = arrayOf(2, 5, 7)
    result = instance.findWithUnknownLength(notPowerOfTwo, target)
    println("Base Case: Not Power of two: $result")
}

