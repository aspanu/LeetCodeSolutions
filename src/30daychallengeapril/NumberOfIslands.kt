package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-17.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3302/
 */
class Solution17 {
    private data class Pt(val row: Int, val col: Int)

    fun numIslands(grid: Array<CharArray>): Int {
        // Each time a new land is found from the main set, add an island, then start looking at the island and its
        // neighbours. Each time a point is looked at off an island, remove it from the main set, then when all points
        // are looked at off that island, go back to the main set and keep looking from there, until it is done.
        if (grid.isEmpty()) return 0

        val pointsExplored = Array(grid.size) {IntArray(grid[0].size) {0} }
        var numIslands = 0
        val islandPointsToExplore = mutableListOf<Pt>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (pointsExplored[row][col] == 1) {
                    continue
                }

                pointsExplored[row][col] = 1

                if (grid[row][col] == '1') {
                    numIslands++
                    islandPointsToExplore.add(Pt(row, col))

                    while(islandPointsToExplore.isNotEmpty()) {
                        val neighboursToExplore = getUnexploredNeighbourPoints(grid, pointsExplored, islandPointsToExplore.removeAt(0))
                        islandPointsToExplore.addAll(neighboursToExplore)
                    }
                }
            }
        }

        return numIslands
    }

    private fun getUnexploredNeighbourPoints(
        grid: Array<CharArray>,
        pointsExplored: Array<IntArray>,
        point: Pt
    ): Collection<Pt> {
        val pointsToExplore = mutableListOf<Pt>()

        val neighbours = getNeighbourPoints(grid, point)

        for (neighbour in neighbours) {
            if (alreadyExplored(pointsExplored, neighbour)) {
                continue
            }
            if (grid[neighbour.row][neighbour.col] == '1') {
                // Check off that this neighbour is explored
                pointsExplored[neighbour.row][neighbour.col] = 1
                // Only add islands to continue looking into
                pointsToExplore.add(neighbour)
            }
        }

        return pointsToExplore
    }

    private fun alreadyExplored(pointsExplored: Array<IntArray>, point: Pt): Boolean {
        return pointsExplored[point.row][point.col] == 1
    }

    private fun getNeighbourPoints(grid: Array<CharArray>, point: Pt): Collection<Pt> {
        val points = mutableListOf<Pt>()
        val left = Pt(row= point.row, col= point.col - 1)
        if (inGrid(grid, left)) {
            points.add(left)
        }
        val right = Pt(row= point.row, col= point.col + 1)
        if (inGrid(grid, right)) {
            points.add(right)
        }
        val up = Pt(row= point.row - 1, col= point.col)
        if (inGrid(grid, up)) {
            points.add(up)
        }
        val down = Pt(row= point.row + 1, col= point.col)
        if (inGrid(grid, down)) {
            points.add(down)
        }

        return points
    }

    private fun inGrid(grid: Array<CharArray>, point: Pt): Boolean {
        if (point.row < 0 || point.col < 0) {
            return false
        }
        if (point.row >= grid.size || point.col >= grid[0].size) {
            return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val sol = Solution17()
    println(sol.numIslands(arrayOf("11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(), "00000".toCharArray())))
    println(sol.numIslands(arrayOf("11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray())))

}