package `30daychallenge`

/**
 * Created by aspanu on 2020-04-22.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3307/
 */

class Solution22 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSumsSeen = mutableMapOf(0 to 1)
        var numSubarrays = 0
        var prefixSum = 0
        for (num in nums) {
            prefixSum += num
            numSubarrays += prefixSumsSeen[prefixSum - k] ?: 0
            prefixSumsSeen[prefixSum] = 1 + (prefixSumsSeen[prefixSum] ?: 0)
        }
        return numSubarrays
    }
}

fun main(args: Array<String>) {
    val sol = Solution22()
    println(sol.subarraySum(intArrayOf(1,1,1), 2))
}