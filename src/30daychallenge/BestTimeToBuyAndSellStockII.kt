package `30daychallenge`

/**
 * Created by aspanu on 2020-04-05.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/
 */

class Solution5 {
    fun maxProfit(prices: IntArray): Int {
        // Basically, we need to find positive runs and calculate the actual amount in those runs
        var maxSum = 0
        var startOfRun = -1
        var prevPrice = -1
        for (num in prices) {
            if (startOfRun == -1) {
                startOfRun = num
            } else if (prevPrice > num) {
                // Run just ended, so if we had a start, add it to the maxSum and then reset everything
                if (startOfRun != -1) {
                    maxSum += prevPrice - startOfRun
                    startOfRun = num
                }
            }
            prevPrice = num
        }
        if (startOfRun != -1 || prevPrice > startOfRun) {
            maxSum += prevPrice - startOfRun
        }

        return maxSum
    }
}

fun main(args: Array<String>) {
    val sol = Solution5()
    println(sol.maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(sol.maxProfit(intArrayOf(1,2,3,4,5)))
    println(sol.maxProfit(intArrayOf(7,6,4,3,1)))
}