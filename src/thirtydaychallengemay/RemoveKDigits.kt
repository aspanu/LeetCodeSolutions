package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-16.
 */

class Solution13 {
    fun removeKdigits(num: String, k: Int): String {
        // Start at the beginning, remove a digit if the next digit is smaller or the same size until we run out of
        // digits to remove, then remove trailing zeroes

        if (k >= num.length) return "0"

        var numStringToRemove = num
        var numLeftToRemove = k
        var currentPointer = 0

        while (numLeftToRemove > 0) {
            when {
                currentPointer == numStringToRemove.length - 1 -> {
                    numStringToRemove = numStringToRemove.removeRange(currentPointer..currentPointer)
                    currentPointer--
                    numLeftToRemove--
                }
                numStringToRemove[currentPointer] > numStringToRemove[currentPointer + 1] -> {
                    // Remove current digit
                    numStringToRemove = numStringToRemove.removeRange(currentPointer..currentPointer)
                    numLeftToRemove--
                    if (currentPointer > 0) currentPointer--
                }
                else -> {
                    currentPointer++
                }
            }
        }

        var foundNonZero = false

        for (i in numStringToRemove.indices) {
            if (numStringToRemove[i] != '0') {
                numStringToRemove = numStringToRemove.substring(i until numStringToRemove.length)
                foundNonZero = true
                break
            }
        }

        if (!foundNonZero) return "0"

        return if (numStringToRemove.isEmpty()) {
            "0"
        } else {
            numStringToRemove
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution13()
    println(sol.removeKdigits("1432219", 3))
    println(sol.removeKdigits("10200", 1))
    println(sol.removeKdigits("10", 2))
    println(sol.removeKdigits("100", 1))
    println(sol.removeKdigits("112", 1))
    println(sol.removeKdigits("1234567890", 9))
    println(sol.removeKdigits("5337", 2))
}