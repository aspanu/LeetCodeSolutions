package `30daychallenge`

/**
 * Created by aspanu on 2020-04-01.
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
 */

class Solution {
    fun singleNumber(nums: IntArray): Int {
        if (nums.size == 1)
            return nums[0]

        for (i in 1 until nums.size) {
            nums[0] = nums[0] xor nums[i]
        }

        return nums[0]
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.singleNumber(intArrayOf(2,2,1)))
    println(sol.singleNumber(intArrayOf(4,1,2,1,2)))
}