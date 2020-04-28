package `30daychallenge`

import kotlin.math.max

/**
 * Created by aspanu on 2020-04-27.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3312/
 */

class Solution27 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        // The current maximum matrix will be 1 + minimum of the up, left and up-left neighbours
        // i.e. maxMatrix[r][c] = min([r-1,c],[r,c-1],[r-1,c-1]) + 1
        if (matrix.isEmpty()) return 0

        val maxMatrix = Array(matrix.size) { IntArray(matrix[0].size) {0} }
        var maxValue = 0

        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                if ((row == 0 || col == 0) && matrix[row][col] == '1') {
                    maxMatrix[row][col] = 1
                    if (1 > maxValue) maxValue = 1
                } else if (matrix[row][col] == '1') {
                    maxMatrix[row][col] =  maxMatrix[row - 1][col].coerceAtMost(maxMatrix[row][col - 1]).coerceAtMost(maxMatrix[row - 1][col - 1])+ 1
                    maxValue = max(maxValue, maxMatrix[row][col])
                }
            }
        }

        return maxValue * maxValue
    }
}

fun main(args: Array<String>) {
    val sol = Solution27()
    println(sol.maximalSquare(arrayOf(charArrayOf('1' ,'0' ,'1' ,'0' ,'0'), charArrayOf('1' ,'0' ,'1' ,'1' ,'1'), charArrayOf('1' ,'1' ,'1' ,'1' ,'1'), charArrayOf('1' ,'0' ,'0' ,'1' ,'0'))))
}