package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-16.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/
 */

class Solution16 {
    fun checkValidString(s: String): Boolean {
        // ( -> +1, ) -> -1, * -> numStars, which can be reduced to prevent us from ever getting negative.
        // Order matters, so can never get negative, but can be positive
        // To deal with more complex patterns, analyze from both directions, quitting early if ever found to be bad
        var runningTotal = 0
        var numStar = 0
        for (char in s) {
            when (char) {
                '(' -> runningTotal++
                ')' -> runningTotal--
                '*' -> numStar++
                else -> return false
            }
            while (runningTotal < 0 && numStar > 0) {
                runningTotal++
                numStar--
            }
            if (runningTotal < 0) return false
        }
        if (numStar < runningTotal) {
            return false
        }

        runningTotal = 0
        numStar = 0
        for (char in s.reversed()) {
            when (char) {
                ')' -> runningTotal++
                '(' -> runningTotal--
                '*' -> numStar++
                else -> return false
            }
            while (runningTotal < 0 && numStar > 0) {
                runningTotal++
                numStar--
            }
            if (runningTotal < 0) return false
        }

        return numStar >= runningTotal
    }
}

fun main(args: Array<String>) {
    val sol = Solution16()
    println(sol.checkValidString(""))
    println(sol.checkValidString("()"))
    println(sol.checkValidString("(*)"))
    println(sol.checkValidString("(*))"))
    println(sol.checkValidString("(*)))"))
    println(sol.checkValidString(")("))
    println(sol.checkValidString("*)()"))
    println(sol.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"))

}