package `30daychallenge`

/**
 * Created by aspanu on 2020-04-13.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/
 */

class Solution13 {
    fun findMaxLength(nums: IntArray): Int {
        // Let 0 add -1 and 1 add +1 to the sum
        // Keep first sum in a map of sum value -> index, where 0 -> -1 (since that's the first time we hit that)
        // If we hit a current sum already in the map, check to see what the run is for that value, if we don't, then
        // add it to the map
        val sumMap = mutableMapOf(0 to -1)
        var sum = 0
        var longestRun = 0
        for (i in nums.indices) {
            if (nums[i] == 0) sum--
            else sum++
            if (!sumMap.containsKey(sum)) {
                sumMap[sum] = i
            } else {
                val currentRun = i - sumMap[sum]!!
                if (currentRun > longestRun) longestRun = currentRun
            }
        }
        return longestRun
    }
}

fun main(args: Array<String>) {
    val sol = Solution13()
    println(sol.findMaxLength(intArrayOf(1, 0)))
    println(sol.findMaxLength(intArrayOf(0, 1, 0)))
    println(sol.findMaxLength(intArrayOf(0, 0, 0, 1, 1, 1)))
}