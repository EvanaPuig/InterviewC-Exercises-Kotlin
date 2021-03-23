package ch0hashTablesAndSorting

/*
Statement: Given an array of Integers, find a pair of integers that sums to a number target.
Example: If A = [6,3,5,2,1,7], target = 4, Result = [3,1]
Level: Easy

Questions to Clarify with interviewer:
	Q. How do you want the output?
	A. Return a pair of numbers.

	Q. What if there are multiple pairs that sum to Target?
	A. Return any pair.

	Q. What to return if there are no pairs that sum to Target?
	A. Return null.
 */

class TwoSum {
    // Brute Force
    // O(n^2) time * tradeoff *
    // O(1) space * Optimal *
    fun twoSumBruteForce(a: Array<Int>?, target: Int) : Pair<Int, Int>? {
        if (a.isNullOrEmpty())
            return null

        for ( i in 0..(a.size - 2)) {
            for(j in 1 until a.size) {
                if( a[i] + a[j] == target)
                    return Pair(a[i], a[j])
            }
        }
        return null
    }

    // Hash table
    // O(n) time * Optimal *
    // O(n) space * tradeoff *
    fun twoSumHashTable(a: Array<Int>?, target: Int) : Pair<Int, Int>? {
        if (a.isNullOrEmpty())
            return null

        val hashSet = hashSetOf<Int>()

        for (i in a.indices) {
            if(hashSet.contains(target - a[i]))
                return Pair(target - a[i], a[i])
            hashSet.add(a[i])
        }

        return null
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: empty array, null array
    Base Cases: single element, two elements (pair-exists/not-exists) Regular Cases: more than 2 elements (pair-exists/not-exists)
     */
    val instance = TwoSum()
    val result = 5

    // Brute Force Cases:
    // 1. Empty array
    val emptyArraySample = arrayOf<Int>()
    println("Brute Force Empty array: ${instance.twoSumBruteForce(emptyArraySample, result)}")

    // 2. Null array
    val nullArraySample = null
    println("Brute Force Null array: ${instance.twoSumBruteForce(nullArraySample, result)}")

    // 3. Array with one element
    val singleElementArraySample = arrayOf(5)
    println("Brute Force Single array: ${instance.twoSumBruteForce(singleElementArraySample, result)}")

    // 4. Array with two elements that sum result
    val twoElementsArrayThatSum = arrayOf(3, 2)
    println("Brute Force two elements that sum array: ${instance.twoSumBruteForce(twoElementsArrayThatSum, result)}")

    // 5. Array with two elements that don't sum result
    val twoElementsArrayThatDontSum = arrayOf(5, 5)
    println("Brute Force two elements don't sum array: ${instance.twoSumBruteForce(twoElementsArrayThatDontSum, result)}")

    // 6. Array with many elements that sum result
    val sample1 = arrayOf(7, 5, 2, 1, 0, 2, 3)
    println("Brute Force Regular Case that sums: ${instance.twoSumBruteForce(sample1, result)}")

    // 7. Array with many elements that don't sum result
    val sample2 = arrayOf(7, 11, 8, 9, 6, 10, 12)
    println("Brute Force Regular Case that doesn't sum: ${instance.twoSumBruteForce(sample2, result)}")

    // Hash table Cases:
    // 1. Empty array
    println("Hash Table Empty array: ${instance.twoSumHashTable(emptyArraySample, result)}")

    // 2. Null array
    println("Hash Table Null array: ${instance.twoSumHashTable(nullArraySample, result)}")

    // 3. Array with one element
    println("Hash Table Single array: ${instance.twoSumHashTable(singleElementArraySample, result)}")

    // 4. Array with two elements that sum result
    println("Hash Table Two elements different array: ${instance.twoSumHashTable(twoElementsArrayThatSum, result)}")

    // 5. Array with two elements that don't sum result
    println("Hash Table Two elements same array: ${instance.twoSumHashTable(twoElementsArrayThatDontSum, result)}")

    // 6. Array with many elements that sum result
    println("Hash Table Force Regular Case that sums: ${instance.twoSumHashTable(sample1, result)}")

    // 7. Array with many elements that don't sum result
    println("Hash Table Regular Case that doesn't sum: ${instance.twoSumBruteForce(sample2, result)}")
}