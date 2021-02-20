package hashTablesAndSorting

/*
Find duplicates in an Array of Integers
Level: Easy
 */

class ArrayDuplicates {
    // Brute force
    // O(1) space
    // O(n^2) time
    fun findArrayDuplicates(a: Array<Int>?): Int? {
        a?.let {
            for (i in 0 until (it.size)) {
                for (j in (i+1) until (a.size)) {
                    if (a[i] == a[j]) {
                        return a[i]
                    }
                }
            }
        }
        return null
    }

    // Sorting
    // O(1) space * Optimal *
    // O(n log n) time because of sorting * tradeoff *
    fun findArrayDuplicatesSorting(a: Array<Int>?): Int? {
        a?.let {
            a.sort()
            for (i in 0..a.size - 2) {
                if (a[i] ==  a[i+1]) {
                    return a[i]
                }
            }
        }
        return null
    }

    // HashTable
    // O(n) space * tradeoff *
    // O(n) time * Optimal *
    fun findArrayDuplicatesHashTable(a: Array<Int>?): Int? {
        val hashMap = hashSetOf<Int>()

        a?.let {
            for (item in a) {
                if (hashMap.contains(item)) {
                    return item
                }
                hashMap.add(item)
            }
        }
        return null
    }
}

fun main() {
     val instance = ArrayDuplicates()

    // Brute Force Test Cases:
    // 1. Empty Array
    val emptyArraySample = arrayOf<Int>()

    println("Brute Force Empty array: ${instance.findArrayDuplicates(emptyArraySample)}")

    // 2. Null array
    val nullArraySample = null

    println("Brute Force Null array: ${instance.findArrayDuplicates(nullArraySample)}")

    // 3. Single Element
    val singleElementArraySample = arrayOf(5)

    println("Brute Force Single array: ${instance.findArrayDuplicates(singleElementArraySample)}")

    // 4. Two elements Different
    val twoElementsArrayDifferentSample = arrayOf(5, 2)

    println("Brute Force Two elements different array: ${instance.findArrayDuplicates(twoElementsArrayDifferentSample)}")

    // 5. Two elements Same
    val twoElementsArraySameSample = arrayOf(5, 5)

    println("Brute Force Two elements same array: ${instance.findArrayDuplicates(twoElementsArraySameSample)}")

    // 6. Regular Case with duplicates
    val sample1 = arrayOf(7, 5, 2, 1, 0, 2, 3)

    println("Brute Force Regular Case with duplicates: ${instance.findArrayDuplicates(sample1)}")

    // 7. Regular Case without duplicates
    val sample2 = arrayOf(7, 5, 2, 1, 0, 3, 4)

    println("Brute Force Regular Case without duplicates: ${instance.findArrayDuplicates(sample2)}")



    // Sorting Test Cases:
    // 1. Empty Array
    println("Sorting Empty array: ${ArrayDuplicates().findArrayDuplicatesSorting(emptyArraySample)}")

    // 2. Null array
    println("Sorting Null array: ${ArrayDuplicates().findArrayDuplicatesSorting(nullArraySample)}")

    // 3. Single Element
    println("Sorting Single array: ${ArrayDuplicates().findArrayDuplicatesSorting(singleElementArraySample)}")

    // 4. Two elements
    println("Sorting Two elements different array: ${ArrayDuplicates().findArrayDuplicatesSorting(twoElementsArrayDifferentSample)}")

    // 5. Two elements Same
    println("Sorting Two elements same array: ${ArrayDuplicates().findArrayDuplicatesSorting(twoElementsArraySameSample)}")

    // 6. Regular Case 1
    println("Sorting Regular Case with duplicates: ${ArrayDuplicates().findArrayDuplicatesSorting(sample1)}")

    // 7. Regular Case 2
    println("Sorting Regular Case without duplicates: ${ArrayDuplicates().findArrayDuplicatesSorting(sample2)}")

    // Hash table Test Cases:
    // 1. Empty Array
    println("Hash table Empty array: ${ArrayDuplicates().findArrayDuplicatesHashTable(emptyArraySample)}")

    // 2. Null array
    println("Hash table Null array: ${ArrayDuplicates().findArrayDuplicatesHashTable(nullArraySample)}")

    // 3. Single Element
    println("Hash table Single array: ${ArrayDuplicates().findArrayDuplicatesHashTable(singleElementArraySample)}")

    // 4. Two elements
    println("Hash Table Two elements different array: ${ArrayDuplicates().findArrayDuplicatesHashTable(twoElementsArrayDifferentSample)}")

    // 5. Two elements Same
    println("Hash Table Two elements same array: ${ArrayDuplicates().findArrayDuplicatesHashTable(twoElementsArraySameSample)}")

    // 6. Regular Case 1
    println("Hash Table Regular Case with duplicates: ${ArrayDuplicates().findArrayDuplicatesHashTable(sample1)}")

    // 7. Regular Case 2
    println("Hash Table Regular Case without duplicates: ${ArrayDuplicates().findArrayDuplicatesHashTable(sample2)}")
}