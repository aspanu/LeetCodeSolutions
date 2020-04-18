package `30daychallenge`

/**
 * Created by aspanu on 2020-04-18.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3303/
 */

class Solution18 {

    fun minPathSum(grid: Array<IntArray>): Int {
        // You can keep track of the the current minimum path sum at any point and then go from there each time
        val minSumGrid = Array(grid.size) { IntArray(grid[0].size) }
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                val left = if (col == 0) null else minSumGrid[row][col - 1]
                val up = if (row == 0) null else minSumGrid[row - 1][col]

                minSumGrid[row][col] = (listOfNotNull(left, up).min() ?: 0) + grid[row][col]

            }
        }
        return minSumGrid.last().last()
    }

    // Apparently, we shouldn't do it by graph search, but instead use dp.
//    var minimumSum = Int.MAX_VALUE
//
//    private data class Pt(val row: Int, val col: Int)
//
//    fun minPathSum(grid: Array<IntArray>): Int {
//        if (grid.isEmpty()) return 0
//
//        val startingPoint = Pt(0, 0)
//        val currentSum = 0
//
//        recursiveDownAndRightLookup(grid, startingPoint, currentSum)
//
//        return minimumSum
//    }
//
//    private fun recursiveDownAndRightLookup(grid: Array<IntArray>, pointIn: Pt, sum: Int) {
//        val newSum = sum + grid[pointIn.row][pointIn.col]
//        val points = getValidNeighbours(grid, pointIn)
//
//        if (points.isEmpty()) {
//            if (newSum < minimumSum) {
//                minimumSum = newSum
//            }
//        } else {
//            for (point in points) {
//                recursiveDownAndRightLookup(grid, point, newSum)
//            }
//        }
//    }
//
//    private fun getValidNeighbours(grid: Array<IntArray>, pt: Pt): List<Pt> {
//        val right = Pt(pt.row, pt.col + 1)
//        val down = Pt(pt.row + 1, pt.col)
//
//        val points = mutableListOf<Pt>()
//
//        if (inGrid(grid, right)) {
//            points.add(right)
//        }
//        if (inGrid(grid, down)) {
//            points.add(down)
//        }
//
//        return points
//    }
//
//    private fun inGrid(grid: Array<IntArray>, point: Pt): Boolean {
//        if (point.row >= grid.size || point.col >= grid[0].size) {
//            return false
//        }
//        return true
//    }
}

fun main(args: Array<String>) {
    val sol = Solution18()
    println(sol.minPathSum(arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))))
    println(sol.minPathSum(arrayOf(intArrayOf(5,0,1,1,2,1,0,1,3,6,3,0,7,3,3,3,1),intArrayOf(1,4,1,8,5,5,5,6,8,7,0,4,3,9,9,6,0),intArrayOf(2,8,3,3,1,6,1,4,9,0,9,2,3,3,3,8,4),intArrayOf(3,5,1,9,3,0,8,3,4,3,4,6,9,6,8,9,9),intArrayOf(3,0,7,4,6,6,4,6,8,8,9,3,8,3,9,3,4),intArrayOf(8,8,6,8,3,3,1,7,9,3,3,9,2,4,3,5,1),intArrayOf(7,1,0,4,7,8,4,6,4,2,1,3,7,8,3,5,4),intArrayOf(3,0,9,6,7,8,9,2,0,4,6,3,9,7,2,0,7),intArrayOf(8,0,8,2,6,4,4,0,9,3,8,4,0,4,7,0,4),intArrayOf(3,7,4,5,9,4,9,7,9,8,7,4,0,4,2,0,4),intArrayOf(5,9,0,1,9,1,5,9,5,5,3,4,6,9,8,5,6),intArrayOf(5,7,2,4,4,4,2,1,8,4,8,0,5,4,7,4,7),intArrayOf(9,5,8,6,4,4,3,9,8,1,1,8,7,7,3,6,9),intArrayOf(7,2,3,1,6,3,6,6,6,3,2,3,9,9,4,4,8))))
}