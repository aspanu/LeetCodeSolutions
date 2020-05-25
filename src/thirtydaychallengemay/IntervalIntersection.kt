package thirtydaychallengemay

import kotlin.math.max
import kotlin.math.min

/**
 * Created by aspanu on 2020-05-25.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
 */

class Solution23 {
    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        var aPointer = 0
        var bPointer = 0
        val intersectionRanges = mutableListOf<IntArray>()
        while (aPointer < A.size && bPointer < B.size) {
            val intersection = getIntersection(A[aPointer], B[bPointer])
            if (intersection.isNotEmpty()) intersectionRanges.add(intersection)
            if (firstSmallerThanSecond(A[aPointer], B[bPointer])) {
                aPointer++
            } else {
                bPointer++
            }
        }
        return intersectionRanges.toTypedArray()
    }

    private fun firstSmallerThanSecond(aRange: IntArray, bRange: IntArray) = aRange[1] < bRange[1]

    private fun getIntersection(aRange: IntArray, bRange: IntArray): IntArray {
        if (aRange[1] < bRange[0] || bRange[1] < aRange[0]) return intArrayOf()
        return intArrayOf(max(aRange[0], bRange[0]), min(aRange[1], bRange[1]))
    }
}

fun main(args: Array<String>) {
    val sol = Solution23()
    println(sol.intervalIntersection(
        arrayOf(intArrayOf(0,2), intArrayOf(5,10), intArrayOf(13,23), intArrayOf(24,25)),
        arrayOf(intArrayOf(1,5), intArrayOf(8,12), intArrayOf(15,24), intArrayOf(25,26)))
        .map { it.joinToString(",") }.toList().joinToString("|")
    )
    // expected: [1,2],[5,5],[8,10],[15,23],[24,24],[25,25]
}