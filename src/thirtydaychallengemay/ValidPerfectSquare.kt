package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-09.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
 */

class Solution9 {
    fun isPerfectSquare(num: Int): Boolean {
        // Rolling my eyes that we can't use `sqrt`, so dumb
        for (i in 0..num) {
            val square = i * i
            if (square > num) {
                return false
            }
            if (square == num) {
                return true
            }
        }
        return false
    }
}

fun main(args: Array<String>) {
    val sol = Solution9()
    println(sol.isPerfectSquare(16)) // true
    println(sol.isPerfectSquare(14)) // false

}