package ch1ArraysAndStrings1.partitioningArrays

/*
Question 12

Given an array with n marbles colored Red, White or Blue, sort them so that marbles of the same color are adjacent, with the colors in the order Red, White and Blue.
Assume the colors are given as numbers - 0 (Red), 1 (White) and 2 (Blue).
For example, if A = [1,0,1,2,1,0,1,2], Output = [0,0,1,1,1,1,2,2].
Level: Medium

Questions to Clarify:
Q. What to do if the input has an unknown color?
A. Throw an Exception

Q. Do I need to move around the existing elements of the array, or can I count the elements (for example, 4 zeros) and then fill them up in a new array?
A. Yes, you need to move elements around. A marble is represented as an integer in this problem, but
in reality there might be more information about a marble in each element.
 */

class ThreeColorMarbles {
    enum class Color(val colorId: Int) {
        RED(0),
        WHITE(1),
        BLUE(2);
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    fun redWhiteBlue(a: Array<Int>?): Array<Int>? {
        if (a.isNullOrEmpty())
            return a

        var lowBoundary = 0
        var highBoundary = a.size - 1
        var i = 0

        while (i <= highBoundary) {
            when {
                a[i] == Color.RED.colorId -> {
                    swap(a, i, lowBoundary)
                    lowBoundary++
                    i++
                }
                a[i] == Color.BLUE.colorId -> {
                    swap(a, i, highBoundary)
                    highBoundary--
                }
                a[i] == Color.WHITE.colorId -> {
                    i++
                }
                else -> {
                    println("Throwing error here")
                    return null
                }
            }
        }
        return a
    }

    private fun swap(a: Array<Int>, firstItem: Int, secondItem: Int) {
        val temp = a[firstItem]
        a[firstItem] = a[secondItem]
        a[secondItem] = temp
    }

}

fun main() {
    /*
    Test Cases
    Edge Cases: empty array, null array, invalid color
    Base Cases: single element, two elements
    Regular Cases: list has element with - all 3 colors, only 2 colors, only 1 color
     */

    val instance = ThreeColorMarbles()
    var result: Array<Int>?

    // Corner Cases:
    // 1. Empty array
    val emptyArray = arrayOf<Int>()
    result = instance.redWhiteBlue(emptyArray)
    println("Corner Case: Empty Array: ${result?.joinToString(", ")}")

    // 2. Null array
    val nullArray = null
    result = instance.redWhiteBlue(nullArray)
    println("Corner Case: Null Array: ${result?.joinToString(", ")}")

    // 3. Invalid color
    val invalidColor = arrayOf(5, 5, 5, 2)
    result = instance.redWhiteBlue(invalidColor)
    println("Corner Case: Invalid Array: ${result?.joinToString(", ")}")

    // Base Cases:
    // 4. Array with one element
    val singleElementArray = arrayOf(1)
    result = instance.redWhiteBlue(singleElementArray)
    println("Base Case: Array with one element: ${result?.joinToString(", ")}")

    // 5. Array with two elements
    val twoElementArray = arrayOf(2, 1)
    result = instance.redWhiteBlue(twoElementArray)
    println("Base Case: Array with two elements: ${result?.joinToString(", ")}")

    //  Regular cases:
    // 6. Array with all 3 colors
    val threeColorsArray = arrayOf(0, 0, 1, 0, 2, 0, 2)
    result = instance.redWhiteBlue(threeColorsArray)
    println("Regular Case: Array with 3 colors: ${result?.joinToString(", ")}")

    // 7. Array with 2 colors
    val twoColorsArray = arrayOf(2, 1, 1, 2, 1)
    result = instance.redWhiteBlue(twoColorsArray)
    println("Regular Case: Array with 2 colors: ${result?.joinToString(", ")}")

    // 8. Array  with 1 color
    val arrayWithOneColor = arrayOf(1, 1, 1, 1)
    result = instance.redWhiteBlue(arrayWithOneColor)
    println("Regular Case: Array with 1 color: ${result?.joinToString(", ")}")
}