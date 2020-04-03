package `30daychallenge`

/**
 * Created by aspanu on 2020-04-02.
 */

class Solution2 {
    fun isHappy(n: Int): Boolean {
        val visitedNumbers = mutableSetOf(n)
        var currentNum = n
        while (true) {
            val newNum = squareOfDigits(currentNum)
            if (newNum == 1) return true
            if (visitedNumbers.contains(newNum)) return false
            visitedNumbers.add(newNum)
            currentNum = newNum
        }
    }

    private fun squareOfDigits(number: Int): Int {
        val digits = digitsOfNumber(number)
        var sum = 0
        digits.forEach { sum += (it * it) }
        return sum
    }

    private fun digitsOfNumber(number: Int): List<Int> {
        val digits = mutableListOf<Int>()
        number.toString().forEach { digits.add(Character.getNumericValue(it)) }
        return digits
    }
}

fun main(args: Array<String>) {
    val sol = Solution2()
    println(sol.isHappy(19))
    println(sol.isHappy(15))
}
