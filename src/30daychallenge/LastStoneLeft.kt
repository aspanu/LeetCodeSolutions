package `30daychallenge`

/**
 * Created by aspanu on 2020-04-12.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
 */

class Solution12 {
    fun lastStoneWeight(stones: IntArray): Int {
        val stonesRemaining = stones.sortedDescending().toMutableList()

        return recursiveLastStoneWeight(stonesRemaining)
    }

    private fun recursiveLastStoneWeight(stonesRemaining: MutableList<Int>): Int {
        println("Current list of stones remaining: $stonesRemaining")
        if (stonesRemaining.isEmpty()) {
            return 0
        } else if (stonesRemaining.size == 1) {
            return stonesRemaining[0]
        }

        val stoneOne = stonesRemaining.removeAt(0)
        val stoneTwo = stonesRemaining.removeAt(0)

        if (stoneOne != stoneTwo) {
            stonesRemaining.add(stoneOne - stoneTwo)
        }

        return recursiveLastStoneWeight(stonesRemaining.sortedDescending().toMutableList())
    }
}

fun main(args: Array<String>) {
    val sol = Solution12()
    println(sol.lastStoneWeight(intArrayOf(2, 7, 4, 1, 16, 1)))
}
