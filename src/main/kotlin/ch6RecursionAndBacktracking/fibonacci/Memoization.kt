package ch6RecursionAndBacktracking.fibonacci

/*
Question 26

Level: Very Easy

Statement:
    Find the nth number in the Fibonacci series. Fibonacci series is as follows:
    1,1,2,3,5,8,13,21,..

    After the first two 1’s, each number is the sum of the previous two numbers.

Questions to Clarify: N/A
 */

class Memoization {
    /*
    Complexity
        Time Complexity: O(n)
        Space Complexity: O(n)
     */

    fun fibonacci(n: Int): Int {
        return fibonacci(n, hashMapOf())
    }

    private fun fibonacci(n: Int, memo: HashMap<Int, Int>): Int {
        if (n == 1 || n == 2)
            return 1
        if (memo.containsKey(n)) //lookup memo
            return memo[n]!!

        val result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
        memo[n] = result
        return result
    }
}

fun main() {
    val instance = Memoization()
    println(instance.fibonacci(1))

    println(instance.fibonacci(2))

    println(instance.fibonacci(5))

    println(instance.fibonacci(7))
}