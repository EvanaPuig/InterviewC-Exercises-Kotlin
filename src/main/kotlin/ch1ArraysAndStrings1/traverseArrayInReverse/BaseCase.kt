package ch1ArraysAndStrings1.traverseArrayInReverse

/*
Statement: Given an array of numbers, replace each even number with two of the same number. e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8]. Assume that the array has enough space to accommodate the result.
Level: Easy

Questions to Clarify with interviewer:
    Q. How do you want to return the result?
    A. Modify the input array.

    Q. What would an empty element contain?
    A. -1
 */

class BaseCase {
    /*
    Time Complexity: O(n) aka linear time
    Space Complexity: O(1) aka constant space
     */
    fun cloneEvenNumbers(a: Array<Int>?): Array<Int>? {
        if(a.isNullOrEmpty())
            return a

        var end = a.size
        var lastNumIndex = getLastNumberIndex(a)

        while (lastNumIndex >= 0) {
            if ( a[lastNumIndex] % 2 == 0)
                a[--end] = a[lastNumIndex]
            a[--end] = a[lastNumIndex]
            lastNumIndex--
        }
        return a
    }

    private fun getLastNumberIndex(a: Array<Int>): Int {
        var lastIndex = a.size - 1
        while (lastIndex >= 0 && a[lastIndex] == -1)
            lastIndex--

        return lastIndex
    }
}

fun main() {
    /*
    Test Cases:
    Corner Cases - null, empty array, array with only blanks
    Base Cases - one odd number, one even number
    Regular Cases - only odd numbers, only even numbers, both odd and even numbers
     */

    val instance = BaseCase()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.cloneEvenNumbers(emptyArray)
    println("Base Case: Empty Array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.cloneEvenNumbers(nullArray)
    println("Base Case: Null Array: ${result?.joinToString(", ")}")

    // 3. Array with only blanks
    val blanksArray = arrayOf(-1,-1,-1,-1)
    result = instance.cloneEvenNumbers(blanksArray)
    println("Base Case: Array with only blanks: ${result?.joinToString(", ")}")

    // Base Cases:
    // 4. Array with one odd number
    val oneOdd = arrayOf(5)
    result = instance.cloneEvenNumbers(oneOdd)
    println("Base Case: Array with one odd number: ${result?.joinToString(", ")}")

    // 5. Array with one even number
    val oneEven = arrayOf(2, -1)
    result = instance.cloneEvenNumbers(oneEven)
    println("Base Case: Array with one even number: ${result?.joinToString(", ")}")

    //  Regular cases:
    // 5. Array with only odd numbers
    val onlyOdd = arrayOf(3, 9, 1, 7, 5)
    result = instance.cloneEvenNumbers(onlyOdd)
    println("Base Case: Array with only odd numbers: ${result?.joinToString(", ")}")

    // 6. Array with only even numbers
    val onlyEven = arrayOf(2, 4, 6, -1, -1, -1)
    result = instance.cloneEvenNumbers(onlyEven)
    println("Base Case: Array with only even numbers: ${result?.joinToString(", ")}")

    // 7. Array with both even and odd numbers
    val normalCase = arrayOf(7, 11, 8, 9, 6, 10, 12, -1, -1, -1, -1)
    result = instance.cloneEvenNumbers(normalCase)
    println("Base Case: Array with both even and odd numbers: ${result?.joinToString(", ")}")
}