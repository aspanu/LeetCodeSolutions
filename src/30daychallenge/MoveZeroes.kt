package `30daychallenge`

/**
 * Created by aspanu on 2020-04-04.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
 */

class Solution4 {
    fun moveZeroes(nums: IntArray): Unit {
        // Iterate through array, if element is zero, add it to the zeroes subarray and move on
        // If the element is not zero, swap it with the first placed element in the zeroes subarray
        var firstZeroIndex = -1
        for (i in nums.indices) {
            if (nums[i] == 0) {
                if (firstZeroIndex == -1) firstZeroIndex = i
            } else {
                if (firstZeroIndex != -1) {
                    nums[firstZeroIndex] = nums[i]
                    nums[i] = 0
                    firstZeroIndex++
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution4()
    val array = intArrayOf(0,1,0,3,12)
    sol.moveZeroes(array)
    println(array.joinToString(","))
    val array2 = intArrayOf(2,1,2,3,12)
    sol.moveZeroes(array2)
    println(array2.joinToString(","))
}