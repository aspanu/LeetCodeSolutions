package `30daychallenge`

/**
 * Created by aspanu on 2020-04-23.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/
 */

class Solution23 {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var topNum = n
        while (topNum > m) topNum = topNum and (topNum - 1)
        return m and topNum
    }
}

fun main(args: Array<String>) {
    val sol = Solution23()
    println(sol.rangeBitwiseAnd(5,7)) // 4
    println(sol.rangeBitwiseAnd(0,1)) // 0
    println(sol.rangeBitwiseAnd(6,7)) // 6
    println(sol.rangeBitwiseAnd(31, 32)) // 0
    println(sol.rangeBitwiseAnd(18, 19)) // 18
    println(sol.rangeBitwiseAnd(18, 20)) // 16
}