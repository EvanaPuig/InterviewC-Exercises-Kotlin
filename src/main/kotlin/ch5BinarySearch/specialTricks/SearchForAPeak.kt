package ch5BinarySearch.specialTricks

/*
Level: MediumA peak element in an array A is an A[i] where its neighboring elements are less than A[i].
So, A[i - 1] < A[i] and A[i + 1] < A[i].

Assume there are no duplicates.
Also, assume that A[-1] and A[length] are negative infinity (-∞).So A[0] can be a peak if A[1] < A[0].

A = [1,3,4,5,2] => Peak = 5
A = [5,3,1] => Peak = 5
A = [1,3,5] => Peak = 5

### Questions to Clarify:
	Q. Can there be negative numbers in the array
	A. Yes, there can be both -ve and +ve numbers

	Q. How do we return the output?
	A. Return the index of a peak.

	Q. What if the array is empty or null?
	A. Return -1
 */

class SearchForAPeak {
    /*
    ### Complexity
    Time Complexity: O(log(n))
    Space Complexity: O(1)
     */
    fun findPeak(a: Array<Int>?): Int {
        if (a.isNullOrEmpty())
            return -1

        var low = 0
        var high = a.size - 1

        while (low <= high){
            val mid = low + (high - low) / 2

            val left = if (mid > 0) a[mid - 1] else Integer.MIN_VALUE
            val right = if (mid < a.size - 1) a[mid + 1] else Integer.MIN_VALUE

            when {
                (left < a[mid]) && (right > a[mid]) ->
                    low = mid + 1 // go right
                (right < a[mid]) && (left > a[mid]) ->
                    high = mid - 1 // go left
                (right > a[mid]) && (left > a[mid]) ->
                    high = mid - 1 // valley go either way
                else ->
                    return mid
            }
        }
        return -1 // shouldn't happen, can also return an exception
    }
}

fun main() {
/*
Test Cases
    Edge Cases: empty array, null array
    Base Cases: single element
    Regular Cases: peak in the middle, peak at a[0], peak at end of array
 */

    val instance = SearchForAPeak()
    var result: Int? = null

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.findPeak(emptyArray)
    println("Corner Case: Empty Array: $result")

    // 2. Null array
    val nullArray = null
    result = instance.findPeak(nullArray)
    println("Corner Case: Null Array: $result")

    // Base Cases
    // 3. Single element
    val singleElementArray = arrayOf(3)
    result = instance.findPeak(singleElementArray)
    println("Base Case: Single Element Array: $result")

    // Regular cases
    // 4. Peak in the middle,
    val peakInTheMiddleArray = arrayOf(3, 5, 2)
    result = instance.findPeak(peakInTheMiddleArray)
    println("Regular Case: Peak in the Middle Array: $result")

    // 5. Peak at a[0]
    val peakAtBeginning = arrayOf(5, 3, 2)
    result = instance.findPeak(peakAtBeginning)
    println("Regular Case: Peak in the Beginning of the Array: $result")

    // 6. Peak at end of array
    val peakInTheEndOfArray = arrayOf(1, 2, 5)
    result = instance.findPeak(peakInTheEndOfArray)
    println("Regular Case: Peak in the End of the Array: $result")

}