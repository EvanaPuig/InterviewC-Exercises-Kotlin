package ch1ArraysAndStrings1.traverseArrayInReverse

import java.lang.StringBuilder

/*
Statement: Reverse the Words of a Sentence. Given a sentence, reverse the words of the sentence.
For example,
“I live in a house” becomes “house a in live I”
Level: Easy

Questions to Clarify:
Q. What about punctuations (.,)?
A. Assume there are no punctuations.

Q. How to deal with capitalization (uppercase vs lowercase letters)?
A. Ignore the case, keep as it is.

Q. Can I allocate a new String for the result?
A. Yes, you can allocate a new String. Limit the space complexity to O(n).
 */

class ReverseSentence {
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    fun reverseWords(s: String?): String? {
        if (s.isNullOrEmpty())
            return s

        val builder = StringBuilder()
        var currentWordEnd = s.length
        for (i in (s.length - 1) downTo 0) {
            if (s[i] == ' ') {
                if (builder.isNotEmpty()) // not empty, add a space
                    builder.append(' ')

                builder.append(s.substring(i + 1, currentWordEnd))
                currentWordEnd = i
            }
        }
        // add first word
        val firstWord = s.substring(0, currentWordEnd)
        if (builder.isNotEmpty())
            builder.append(' ')
        builder.append(firstWord)

        return builder.toString()
    }
}

fun main() {
    /*
    Corner Cases: null string, empty string, single letter, single space, begins with space, ends with space
    Base Cases: one word, two words
    Regular Cases: 5 words
    */

    val instance = ReverseSentence()

    // Corner Cases:
    // 1. Null String
    println(instance.reverseWords(null))

    // 2. Empty String
    println(instance.reverseWords(""))

    // 3. Single letter
    println(instance.reverseWords("a"))

    // 4. Single Space
    println(instance.reverseWords(" "))

    // 5. Begins with space
    println(instance.reverseWords(" hello world starts with space"))

    // 6. Ends with space
    println(instance.reverseWords("hello world ends with space "))

    // Base Cases:

    // 7. One Word
    println(instance.reverseWords("word"))

    // 8. Two words
    println(instance.reverseWords("two words"))


    // Regular Cases:

    // 9. 5 words
    println(instance.reverseWords("Normal sentence with five words"))
}