package ch1ArraysAndStrings1.traverseFromBothEnds

/*
Question 6

Statement: Two Sum Problem - Find 2 numbers in a sorted array that sum to X.
For example, if  A = [1,2,3,4,5] and X= 9, the numbers are 4 and 5.
Level: Easy

Questions to Clarify with the Interviewer:
    Q. How do return the output?
    A. Return it as a pair of numbers.

    Q. What to return if there is no result?
    A. Return null.

    Q. Can the array have duplicates?
    A. Yes

    Q. If there are more than one pair that qualify, which pair should I return?
      For example, if a=[2,3,4,5] and target=7, the answer could be either {2,5} or {3,4}
    A. Return whichever you like. As long as you return a correct pair, it’s fine.
 */

class TwoSum {
    // TimeComplexity: O(n)
    // Space Complexity: O(1)
    fun twoSum(a: Array<Int>?, result: Int): Pair<Int, Int>? {
        if(a.isNullOrEmpty())
            return null

        var start = 0
        var end = a.size - 1

        while(start < end) {
            val sum = a[start] + a[end]
            when {
                sum < result -> start++
                sum > result -> end--
                else -> return Pair(a[start], a[end])
            }
        }
        return null
    }
}

fun main() {
    /*
    Test Cases:
    Edge Case: empty array, single element
    Base Case: 2 elements (with and w/o sum)
    Regular Case: 3 elements, 4 elements (with and w/o sum and duplicates)
     */

    val instance = TwoSum()
    val result = 5

    // Brute Force Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    println("Empty array: ${instance.twoSum(emptyArray, result)}")

    // 2. Null array
    val nullArray = null
    println("Null array: ${instance.twoSum(nullArray, result)}")

    // 3. Array with one element
    val singleElementArray = arrayOf(5)
    println("Single array: ${instance.twoSum(singleElementArray, result)}")

    // 4. Array with two elements that sum result
    val twoElementsArrayThatSum = arrayOf(2, 3)
    println("Two elements that sum array: ${instance.twoSum(twoElementsArrayThatSum, result)}")

    // 5. Array with two elements that don't sum result
    val twoElementsArrayThatDontSum = arrayOf(5, 5)
    println("Two elements don't sum array: ${instance.twoSum(twoElementsArrayThatDontSum, result)}")

    // 6. Array with many elements that sum result
    val sample1 = arrayOf(0, 1, 2, 2, 3, 5, 7)
    println("Regular Case that sums: ${instance.twoSum(sample1, result)}")

    // 7. Array with many elements that don't sum result
    val sample2 = arrayOf(6, 7, 8, 9, 10, 11, 12)
    println("Regular Case that doesn't sum: ${instance.twoSum(sample2, result)}")
}