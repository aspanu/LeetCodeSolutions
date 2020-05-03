package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-25.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3310/
 */

class Solution25 {
    fun canJump(nums: IntArray): Boolean {
        val size = nums.size
        var maximumJumpIndex = 0

        for (i in 0 until size) {
            if (i > maximumJumpIndex) break

            maximumJumpIndex = Math.max(maximumJumpIndex, i + nums[i])
        }

        return maximumJumpIndex >= size - 1
    }
}

fun main(args: Array<String>) {
    val sol = Solution25()
    println(sol.canJump(intArrayOf(2,3,1,1,4)))
    println(sol.canJump(intArrayOf(3,2,1,0,4)))
}