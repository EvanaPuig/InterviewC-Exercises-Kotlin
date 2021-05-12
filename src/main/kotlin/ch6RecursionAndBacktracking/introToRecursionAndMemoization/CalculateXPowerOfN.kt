package ch6RecursionAndBacktracking.introToRecursionAndMemoization

import java.lang.ArithmeticException
import kotlin.math.abs

/*
Question 33

Level: Easy

Statement:
Power Function: Implement a function to calculate X^N. Both X and N can be positive
or negative. You can assume that overflow doesn’t happen.

(Try doing it in O(log(N)) time)

For example:

 2 ^ 2  = 4
 2 ^ -2 = 0.25
-2 ^ 3  = -8

Questions to Clarify:
	Q. Are both X and N integers?
	A. Yes

	Q. Can the number be both negative and positive?
	A. Yes

	Q. Can the power be negative?
	A. Yes

	Q. Can we assume that the result won’t overflow?
	A. Yes, you can assume that.

	Q. 0^0 or 0^-3 (or any negative number) is undefined. How do we return that?
	A. Throw an exception.
 */

class CalculateXPowerOfN {
    /*
    Complexity:
        Time Complexity: O(log(N))
        Space Complexity: O(log(N)) on call stack
    */

    fun power(x: Int, power: Int): Float {
        if (x == 0 && power <= 0) {
            throw ArithmeticException("undefined")
        }

        var result: Float = positivePower(abs(x), abs(power)).toFloat()

        // handle negative power
        if (power < 0)
            result = 1 / result

        // handle negative x
        if ( x < 0 && power % 2 != 0)
            result *= -1

        return result
    }

    private fun positivePower(x: Int, power: Int): Int {
        if (power == 0)
            return 1
        if (power == 1)
            return x

        val halfPower = positivePower(x, power / 2)

        return if (power % 2 == 0)
            halfPower * halfPower
        else
            x * halfPower * halfPower
    }
}

fun main() {
    /*
    Test Cases
        Base Cases: power is 0, power is 1, x is 0, x is 1
        Regular Cases: both power & x are +ve, both are -ve, both different signs
     */

    val instance = CalculateXPowerOfN()

    // Base Cases:
    // 1. Power is 0
    println("Power is 0: ${instance.power(5, 0)}")

    // 2. Power is 1
    println("Power is 1: ${instance.power(5, 1)}")

    // 3. X is 0
    println("X is 0: ${instance.power(0, 2)}")

    // 4. X is 1
    println("X is 1: ${instance.power(1, 5)}")

    // Regular Cases:
    // 5. Both power and x are +ve
    println("Both power and x are +ve: ${instance.power(5, 2)}")

    // 6. Both power and x are -ve
    println("Both power and x are -ve: ${instance.power(-5, -2)}")

    // 7. Power is +ve and x -ve
    println("Power is +ve and x -ve: ${instance.power(-5, 2)}")

    // 8. Power is -ve and x +ve
    println("Power is -ve and x +ve: ${instance.power(5, -2)}")
}