package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-15.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3300/
 */
class Solution15 {
    fun productExceptSelf(nums: IntArray): IntArray {
        // Get the product of everything together and then divide out each one at a time
        // Cannot use division since '0' will appear at times
        var totalSoFar = 1
        val output = IntArray(nums.size)
        output[0] = totalSoFar
        for (i in 1 until nums.size) {
            totalSoFar *= nums[i - 1]
            output[i] = totalSoFar
        }

        totalSoFar = 1
        for (i in nums.size - 2 downTo 0) {
            totalSoFar *= nums[i + 1]
            output[i] *= totalSoFar
        }

        return output
    }
}

fun main(args: Array<String>) {
    val sol = Solution15()
    println(sol.productExceptSelf(intArrayOf(1,2,3,4)).joinToString(","))
    println(sol.productExceptSelf(intArrayOf(0, 0)).joinToString(","))
    println(sol.productExceptSelf(intArrayOf(1, 0)).joinToString(","))
}