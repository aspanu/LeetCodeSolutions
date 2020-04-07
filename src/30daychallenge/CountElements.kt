package `30daychallenge`

/**
 * Created by aspanu on 2020-04-07.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
 */
class Solution7 {
    fun countElements(arr: IntArray): Int {
        var count = 0
        val containedElements = mutableSetOf<Int>()
        for (num in arr) {
            containedElements.add(num - 1)
        }

        for (num in arr) {
            if (containedElements.contains(num)) {
                count++
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    val sol = Solution7()
    println(sol.countElements(intArrayOf(1,2,3)))
    println(sol.countElements(intArrayOf(1,1,3,3,5,5,7,7)))
    println(sol.countElements(intArrayOf(1,3,2,3,5,0)))
    println(sol.countElements(intArrayOf(1,1,2,2)))
    println(sol.countElements(intArrayOf(2,2,1,1)))
}
