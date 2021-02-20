package arraysAndStrings1.traverseFromBothEnds

/*
Statement: Given a sorted array in non-decreasing order, return an array of squares of each number, also in non-decreasing order.
For example:
[-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
How can you do it in O(n) time?
Level: Easy

Questions to Clarify:
    Q. Can there be both negative and positive numbers?
    A. Yes

    Q. Should the output be a new array or the existing array modified?
    A. Either way is ok.
 */

class ArrayOfSquares {
    fun arrayOfSquares(a: Array<Int>?): Array<Int>? {
        if (a.isNullOrEmpty())
            return a

        var start = 0
        var end = a.size - 1

        var result = arrayOf<Int>()
        var resultIndex = result.size - 1

        while(start <= end) {

        }

        return a
    }
}

fun main() {
    val instance = ArrayOfSquares()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.arrayOfSquares(emptyArray)
    println("Corner Case: Empty Array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.arrayOfSquares(nullArray)
    println("Corner Case: Null Array: ${result?.joinToString(", ")}")

    // Base Cases:
    // 3. Array with one number positive
    val singleElementArray = arrayOf(5)
    result = instance.arrayOfSquares(singleElementArray)
    println("Base Case: Array with one positive element: ${result?.joinToString(", ")}")

    //  Regular cases:
    // 4. Array with one number negative
    val singleNegativeElementArray = arrayOf(-5)
    result = instance.arrayOfSquares(singleNegativeElementArray)
    println("Regular Case: Array with one negative element: ${result?.joinToString(", ")}")

    // 5. Only positive
    val onlyPositivesArray = arrayOf(2, 4, 6)
    result = instance.arrayOfSquares(onlyPositivesArray)
    println("Regular Case: Array with only positives: ${result?.joinToString(", ")}")

    // 6. Only negative
    val onlyNegativesArray = arrayOf(-3, -7, -5, -9, -11)
    result = instance.arrayOfSquares(onlyNegativesArray)
    println("Regular Case: Array with only negatives: ${result?.joinToString(", ")}")

    // 7. Both positive and negative
    val normalArray = arrayOf(2, 4, -8, 6, -12, -1)
    result = instance.arrayOfSquares(normalArray)
    println("Regular Case: Normal array: ${result?.joinToString(", ")}")
}