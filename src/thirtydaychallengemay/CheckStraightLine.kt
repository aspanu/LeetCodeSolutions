package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-08.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
 */

class Solution8 {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size == 2) return true
        val firstVector = Pair(coordinates[1][0] - coordinates[0][0], coordinates[1][1] - coordinates[0][1])

        for (i in 2 until coordinates.size) {
            val secondVector = Pair(coordinates[i][0] - coordinates[0][0], coordinates[i][1] - coordinates[0][1])
            if (crossProduct(firstVector, secondVector) != 0) return false
        }

        return true
    }

    // cross product is ax*by - ay*bx of the 2 vectors. The first vector is the first 2 points, the second vector is the
    // 3rd point and the first point
    private fun crossProduct(firstVector: Pair<Int, Int>, secondVector: Pair<Int, Int>): Int {
        return (firstVector.first * secondVector.second) - (firstVector.second * secondVector.first)
    }

}

fun main(args: Array<String>) {
    val sol = Solution8()
    println(sol.checkStraightLine(arrayOf(intArrayOf(1,2),intArrayOf(2,3),intArrayOf(3,4),intArrayOf(4,5),intArrayOf(5,6),intArrayOf(6,7)))) // true
    println(sol.checkStraightLine(arrayOf(intArrayOf(1,1),intArrayOf(2,2),intArrayOf(3,4),intArrayOf(4,5),intArrayOf(5,6),intArrayOf(7,7)))) // false
}