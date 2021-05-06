package ch6RecursionAndBacktracking.auxiliaryBuffer

/*
Question 29

Level: Medium

Given an N digit phone number, print all the strings that can be made from that phone number. Since 1 and 0 don't correspond to any characters, ignore them.

For example:
213 => AD, AE, AF, BD, BE, BF, CE, CE, CF
456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.

Questions to Clarify:
    Q. Is the phone number of a specific size?
    A.No,it can be of any size

    Q. Can we assume that the input will have only digits?
    A. Yes

    Q. Does the string have to be a valid English word?
    A. No, the string can be anything.

    Q. How do we handle if phone number is empty or null?
    A. Print nothing.
 */

class PhoneNumberMnemonics {
    /*
    Time Complexity: Exponential Complexity - O(4^n), where n is the size of the phone number.

    At each function call, we can call at most 4 function calls. We do this at most N times, so the total
    number of function calls is:
    4X4X4..(n times),which is 4^n

    Space Complexity: O(n), where n is the size of the phone number.
    The O(n) space is taken both by the buffer and the call stack.
     */

    fun printWords(phoneNumber: Array<Int>?) {
        if (phoneNumber.isNullOrEmpty())
            return

        val buffer = arrayOfNulls<Char>(phoneNumber.size)
        printWordsHelper(phoneNumber, buffer, 0, 0)
    }

    private fun printWordsHelper(phoneNumber: Array<Int>, buffer: Array<Char?>, arrayIndex: Int, bufferIndex: Int) {
        // 1. termination case
        if (bufferIndex >= buffer.size || arrayIndex >= phoneNumber.size) {
            for (item in buffer) {
                if (item != null)
                    print(item)
            }
            println()
            return
        }

        // 2. Find candidates for buffer position
        val letters = getLetters(phoneNumber[arrayIndex])

        if (letters.isEmpty())
            printWordsHelper(phoneNumber, buffer, arrayIndex + 1, bufferIndex + 1)

        // 3. place candidates in buffer
        for (letter in letters) {
            buffer[bufferIndex] = letter
            // 4. Recurse to next index
            printWordsHelper(phoneNumber, buffer, arrayIndex + 1, bufferIndex + 1)
        }
    }

    private fun getLetters(digit: Int): CharArray {
        return when(digit) {
            0, 1 -> charArrayOf()
            2 -> charArrayOf('a', 'b', 'c')
            3 -> charArrayOf('d', 'e', 'f')
            4 -> charArrayOf('g', 'h', 'i')
            5 -> charArrayOf('j', 'k', 'l')
            6 -> charArrayOf('m', 'n', 'o')
            7 -> charArrayOf('p', 'q', 'r', 's')
            8 -> charArrayOf('t', 'u', 'v')
            9 -> charArrayOf('w', 'x', 'y', 'z')
            else -> charArrayOf()
        }
    }
}

fun main() {
    /*
    Test Cases:
        Edge Cases: a is empty/null
        Base Cases: a has one number, a has only 1's and 0's
        Regular Cases: a with 1's and 0's, without 1's and 0's
     */

    val instance = PhoneNumberMnemonics()

    // Edge Cases:
    // 1. Empty Array
    val emptyArray = arrayOf<Int>()
    println("Empty Array:")
    instance.printWords(emptyArray)
    println()

    // 2. Null Array
    val nullArray = null
    println("Null Array:")
    instance.printWords(nullArray)
    println()

    // Base Cases:
    // 3. Array has 1 number
    val oneNumberArray = arrayOf(5)
    println("One Number Array Array:")
    instance.printWords(oneNumberArray)
    println()

    // 4. Array has only 1s and 0s
    val oneAndZeroArray = arrayOf(1, 0)
    println("One and Zero Array:")
    instance.printWords(oneAndZeroArray)
    println()

    // Regular Cases:
    // 5. Array with 1s and 0s
    val normalArrayWithOneAndZero = arrayOf(1, 2, 5, 0)
    println("Normal Array with 1s and 0s:")
    instance.printWords(normalArrayWithOneAndZero)
    println()

    // 6. Array without 1s and 0s
    val normalArrayNoOneOrZero = arrayOf(3, 5, 7)
    println("Normal Array NO 1 or 0:")
    instance.printWords(normalArrayNoOneOrZero)
    println()

}