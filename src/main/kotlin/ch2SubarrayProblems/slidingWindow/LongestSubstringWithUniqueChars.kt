package ch2SubarrayProblems.slidingWindow

/*
Given a String, find the longest substring with unique characters.
For example: "whatwhywhere" --> "atwhy"
Level: Medium

Questions to Clarify:
    Q. How to return the result?
    A. Return the start and end indexes of the substring.

    Q. What to return if the array is empty or null?
    A. Return null.

    Q. So the shortest possible substring is just one character?
    A. Yes.

    Q. What to do if there are multiple longest substrings?
    A. Return any one of them.

    Q. Do we have only alphabets?
    A. No, there can be any character.

Note: If the interviewer restricts the input to alphabets,
you can use an array of size 52 (26 x 2) instead of using a Hashmap.
 */

class LongestSubstringWithUniqueChars {
    /*
    Time Complexity: O(n)
    Space Complexity: O(size of character set), which is typically a fixed number, so O(1)
     */

    fun allUnique(s: String?): Pair<Int, Int>? {
        if (s.isNullOrEmpty())
            return null

        val map = hashMapOf<Char, Int>()
        var start = 0
        var end = 0
        var longest = 1

        val charArray = s.toCharArray()
        map[charArray[0]] = 0

        while (end < s.length - 1) {
            // expand end pointer
            end++
            val charToAdd = charArray[end]
            if (map.containsKey(charToAdd) && map[charToAdd]!! >= start)
                start = map[charToAdd]!!.plus(1)
            map[charToAdd] = end

            // update result
            if (end - start + 1 > longest)
                longest = end - start + 1
        }

        return Pair(start, end)
    }
}

fun main() {
    /*
    Test Cases:
    Edge Cases: empty string, null string
    Base Cases: single char, 2 chars (same, different)
    Regular Cases: multiple chars (with/without duplicates)
     */

    val instance = LongestSubstringWithUniqueChars()
    var result: Pair<Int, Int>?

    // Corner Cases:
    // 1. Empty string
    val emptyString = ""
    result = instance.allUnique(emptyString)
    println("Corner Case: Empty String: $result")

    // 2. Null string
    val nullString = null
    result = instance.allUnique(nullString)
    println("Corner Case: Null String: $result")

    // Base Cases
    // 3. Single char
    val singleChar = "a"
    result = instance.allUnique(singleChar)
    println("Base Case: Single Char: $result")

    // 4. two chars (same)
    val twoCharsSame = "aa"
    result = instance.allUnique(twoCharsSame)
    println("Base Case: Two chars same: $result")

    // 5. two chars (different)
    val twoCharsDiff = "ab"
    result = instance.allUnique(twoCharsDiff)
    println("Base Case: Two chars diff: $result")

    // Regular Cases
    // 6. Multiple chars with duplicates
    val multiCharWithDuplicates = "abcdabq"
    result = instance.allUnique(multiCharWithDuplicates)
    println("Regular Case: Multiple char with duplicates: $result")

    // 7. Multiple chars without duplicates
    val multiCharWithOutDuplicates = "abcdefgh"
    result = instance.allUnique(multiCharWithOutDuplicates)
    println("Regular Case: Multiple char without duplicates: $result")
}