package IntToRomanNumeral

/**
 * Created by aspanu on 2020-03-28.
 * Solution for https://leetcode.com/problems/integer-to-roman/
 */


class Solution {
    fun intToRoman(num: Int): String {
        val intToRoman = mapOf(1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C", 90 to "XC", 50 to "L", 40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I")

        // Create static table of ints -> roman numerals, go from the largest to the smallest until the found the first
        // to be smaller than the current number. Subtract it from the current number,
        // if new number is 0,  stop, if not, start at the same number as before and keep going
        val sb = StringBuilder()
        var numInput = num
        for (currentNum in intToRoman.keys) {
            if (currentNum > numInput) continue

            while (currentNum <= numInput) {
                sb.append(intToRoman[currentNum])
                numInput -= currentNum
            }
        }
        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.intToRoman(3))
    println(sol.intToRoman(4))
    println(sol.intToRoman(9))
    println(sol.intToRoman(58))
    println(sol.intToRoman(1994))
}