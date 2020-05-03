package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-03.
 */

class Solution3 {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var rollingSum = 0

        for (number in nums.reversed()) {
            rollingSum += number

            if (rollingSum > maxSum)
                maxSum = rollingSum

            if (rollingSum < 0)
                rollingSum = 0
        }


        return maxSum
    }
}

fun main(args: Array<String>) {
    val sol = Solution3()
    println(sol.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(sol.maxSubArray(intArrayOf(-2147483647)))
}
