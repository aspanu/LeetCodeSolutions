package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-11.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
 */

class Solution11 {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {

        floodFillRecursive(image, sr, sc, newColor, image[sr][sc])

        return image
    }

    private fun floodFillRecursive(image: Array<IntArray>, row: Int, col: Int, newColor: Int, prevColor: Int) {
        if (row < 0 || row >= image.size || col < 0 || col >= image[0].size) return
        if (image[row][col] == newColor) return
        if (image[row][col] != prevColor) return

        image[row][col] = newColor
        floodFillRecursive(image, row - 1, col, newColor, prevColor)
        floodFillRecursive(image, row + 1, col, newColor, prevColor)
        floodFillRecursive(image, row, col - 1, newColor, prevColor)
        floodFillRecursive(image, row, col + 1, newColor, prevColor)
    }
}

fun main(args: Array<String>) {
    val sol = Solution11()
    println(sol.floodFill(arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1)), 1, 1, 2).map { it.joinToString(",") }.toList().joinToString { "[$it]" })
}