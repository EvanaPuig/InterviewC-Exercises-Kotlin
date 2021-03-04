package arraysAndStrings1.traverseFromBothEnds

/*
Statement: Reverse the order of elements in an array. For example, A = [1,2,3,4,5,6], Output = [6,5,4,3,2,1]
Level: Easy

Questions to Clarify with the Interviewer:
    Q. Should the output be a new array or the existing array modified?
    A. Modify the existing array
 */

class ReverseArrayElements {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    fun reverseArray(a: Array<Int>?): Array<Int>? {
        if(a.isNullOrEmpty())
            return a

        var start = 0
        var end = a.size - 1

        while (start < end) {
            swap(a, start, end)
            start++
            end--
        }

        return a
    }

    private fun swap(a: Array<Int>, elementA: Int, elementB: Int) {
        val temp = a[elementA]
        a[elementA] = a[elementB]
        a[elementB] = temp
    }
}

fun main() {
    val instance = ReverseArrayElements()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.reverseArray(emptyArray)
    println("Corner Case: Empty Array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.reverseArray(nullArray)
    println("Corner Case: Null Array: ${result?.joinToString(", ")}")

    // Base Cases:
    // 3. Array with one number
    val singleElementArray = arrayOf(5)
    result = instance.reverseArray(singleElementArray)
    println("Base Case: Array with one elements: ${result?.joinToString(", ")}")

    //  Regular cases:
    // 4. Array with 2 elements
    val twoElementsArray = arrayOf(3, 1)
    result = instance.reverseArray(twoElementsArray)
    println("Regular Case: Array with two elements: ${result?.joinToString(", ")}")

    // 5. Array with 3 elements
    val threeElementsArray = arrayOf(2, 4, 6)
    result = instance.reverseArray(threeElementsArray)
    println("Regular Case: Array with three elements: ${result?.joinToString(", ")}")

    // 6. Array with odd elements
    val oddArray = arrayOf(3, 7, 5, 9, 11)
    result = instance.reverseArray(oddArray)
    println("Regular Case: Array with odd elements: ${result?.joinToString(", ")}")

    // 6. Array with even elements
    val evenArray = arrayOf(2, 4, 8, 6, 12)
    result = instance.reverseArray(evenArray)
    println("Regular Case: Array with even elements: ${result?.joinToString(", ")}")
}