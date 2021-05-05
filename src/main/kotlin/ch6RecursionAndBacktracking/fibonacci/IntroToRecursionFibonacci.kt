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

class IntroToRecursionFibonacci {
    /*
    Complexity
        Time Complexity: O(2^n)
        Space Complexity: O(n)
     */

    fun fibonacci(n: Int): Int {
        return if (n == 1 || n == 2) 1 else fibonacci(n - 1) + fibonacci(n - 2)
    }
}

fun main() {
    val instance = IntroToRecursionFibonacci()
    println(instance.fibonacci(1))

    println(instance.fibonacci(2))

    println(instance.fibonacci(5))

    println(instance.fibonacci(7))
}