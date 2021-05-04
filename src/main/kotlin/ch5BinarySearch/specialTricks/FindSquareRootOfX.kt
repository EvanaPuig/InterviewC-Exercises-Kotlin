package ch5BinarySearch.specialTricks

/*
Question 24

Find the square root of an integer X. For example, squareRoot(4) = 2.
It is ok to find the integer floor of the square root. So squareRoot(5) or squareRoot(8) can also return 2. squareRoot(9) will return 3.

Using Binary Search, you can search for square roots over the integer space.
This is pretty fast because it takes O(log(n)) time. Assume that x*x is less than the integer limit.

Level: Easy

Questions to Clarify:
	Q. Can the input be a negative number?
	A. No, only positive numbers and zero.

 */
class FindSquareRootOfX {
/*
Complexity
Time Complexity: O(log(X))
Space Complexity: O(1)
 */
    fun floorSquareRoot(x: Int): Int{
        if (x == 0)
            return 0

        if (x == 1)
            return 1

        var low = 0
        var high = x/2

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                sqrt(mid) > x -> high = mid - 1
                sqrt(mid) < x -> {
                    if (sqrt(mid + 1) > x)
                        return mid
                    low = mid + 1
                }
                else -> return mid
            }
        }
        return - 1 // shouldn't happen, can return an exception here
    }

    private fun sqrt(x: Int): Int {
        return x*x
    }
}

fun main() {
    /*
    ### Test cases
    Test Cases:
    Edge Cases: 0
    Base Cases: 1, 2, 3
    Regular Cases: exact square root, 1 less/more than square root, etc.
     */

    val instance = FindSquareRootOfX()
    var result: Int? = null

    // Edge Cases:
    // 1. 0
    result = instance.floorSquareRoot(0)
    println("Edge Case: 0: $result")

    // Base Cases:
    // 2. 1
    result = instance.floorSquareRoot(1)
    println("Base Case: 1: $result")

    // 3. 2
    result = instance.floorSquareRoot(2)
    println("Base Case: 2: $result")

    // 4. 3
    result = instance.floorSquareRoot(3)
    println("Base Case: 3: $result")

    // Regular Cases:
    // 5. Exact square root
    result = instance.floorSquareRoot(16)
    println("Base Case: Exact square root: $result")

    // 6. 1 more than square root
    result = instance.floorSquareRoot(17)
    println("Base Case: 1 more than square root: $result")

    // 7. 1 less than square root
    result = instance.floorSquareRoot(15)
    println("Base Case: 1 less than square root: $result")

}