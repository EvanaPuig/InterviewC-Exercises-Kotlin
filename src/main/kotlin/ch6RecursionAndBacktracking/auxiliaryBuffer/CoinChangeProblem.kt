package ch6RecursionAndBacktracking.auxiliaryBuffer

import java.util.*

/*
    Question 34

    Level: Medium

 Statement: Given a set of coin denominations, print out the different ways you can make a target amount.
 You can use as many coins of each denomination as you like.

 For example: If coins are [1,2,5] and the target is 5, output will be:
    [1,1,1,1,1]
    [1,1,1,2]
    [1,2,2]
    [5]

 Questions to Clarify:
	Q. Does [1,2] and [2,1] count as one, i.e, do we care about permutations?
	A. No, we only care about combinations, so [1,2] and [2,1] will count as the same.

	Q. Can we assume that all coins will be integers greater than 0?
	A. Yes
 */

class CoinChangeProblem {
    /*
    Complexity
        Time Complexity: Factorial Complexity

        Note: Typically, interviewers will not ask the time complexity of such complex recursions.

        This one is particularly complex.
        We are generating combinations with repetitions, which is hard to calculate even in combinatorics.
        It comes down to a formula that involves factorials.
        If you’re interested, you can read more about it here,
        but we suggest not spending too much time on this unless you’re just curious.

        Space Complexity: O(Target), because in the worst case,
        both our buffer and the recursion stack will be the size of the target.
        (if we use all 1’s to make target)
     */

    fun printCoins(coins: Array<Int>?, target: Int) {
        if (coins.isNullOrEmpty() || target <= 0)
            return

        printCoinsHelper(coins, target, 0, Stack<Int>(), 0)
    }

    private fun printCoinsHelper(coins: Array<Int>, target: Int, startIndex: Int, buffer: Stack<Int>, sum: Int) {
        // 1. termination cases
        if (sum > target)
            return

        if (sum == target) {
            println(buffer)
            return
        }

        // 2. find candidates
        for ( i in startIndex until coins.size) {
            // 3. place candidates into buffer
            buffer.push(coins[i])

            // 4. recurse
            printCoinsHelper(coins, target, i, buffer, sum + coins[i])
            buffer.pop()
        }
    }
}

fun main() {
    /*
    Test Cases:
        Edge Cases: Coins array is null/empty, Target is 0 or -ve.
	    Base Cases: Coins array is size 1
	    Regular Cases: Target is equal to a coin, target is greater than all coins
     */

    val instance = CoinChangeProblem()

    // Edge Cases:
    // 1. Coins array is null
    println("Coins array is null: ${instance.printCoins(null, 2)}")

    // 2. Coins array is empty
    println("Coins array is empty: ${instance.printCoins(arrayOf(), 2)}")

    // 3. Target is 0
    println("Target is 0: ${instance.printCoins(arrayOf(1, 2, 5), 0)}")

    // 4. Target is negative
    println("Target is negative: ${instance.printCoins(arrayOf(1, 2, 5), -5)}")

    // Base cases:
    // 5. Coins array is size 1
    println("Coins array is size 1: ${instance.printCoins(arrayOf(2), 5)}")

    // Regular Cases
    // 6. Target equal to a coin
    println("Target equal to a coin: ${instance.printCoins(arrayOf(5, 10), 5)}")

    // 7. Target greater than all coins
    println("Target greater than all coins: ${instance.printCoins(arrayOf(1, 2, 5), 12)}")
}