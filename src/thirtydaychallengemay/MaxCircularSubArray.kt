package thirtydaychallengemay

import java.util.*

/**
 * Created by aspanu on 2020-05-17.
 */

class Solution15 {
    fun maxSubarraySumCircular(A: IntArray): Int {
        // Find positive regions and glob them together, circularly
        // If there are none, keep track of the largest negative number and return that immediately
        // If there were positive regions, keep track of their start index and then go through their start indices
        // and see if sequential ones can we globbed together through a negative number barrier
        // Keep track of the largest sum thus far (i.e. the largest positive number)
        // Not finished - lots of edge cases and it's so dirty

        var listToGlob = LinkedList(A.toList())
        var hadPositive = false
        var maximumSeen = Int.MIN_VALUE
        var i = 0
        while (i < listToGlob.size) {
            if (listToGlob[i] > maximumSeen) {
                maximumSeen = listToGlob[i]
            }
            if (listToGlob[i] >= 0) {
                // Glob adjacent integers that are positive
                listToGlob = globAdjacentIntegers(listToGlob, i)
                hadPositive = true
            }
            i++
        }

        // No positives, so just return maximumSeen
        if (!hadPositive) return maximumSeen

        // Find positive indices:
        val positiveIndices = mutableListOf<Int>()

        for (j in listToGlob.indices) {
            if (listToGlob[j] >= 0) {
                positiveIndices.add(j)
            }
        }

        // Check if adjacent positive zones can be globbed together:
        for (j in positiveIndices.size - 1 downTo 1) {
            val negativeBoundary = listToGlob.subList(positiveIndices[j - 1] + 1, positiveIndices[j]).map { it }.sum()
            if (Math.abs(negativeBoundary) <= listToGlob[positiveIndices[j]] && Math.abs(negativeBoundary) <= listToGlob[positiveIndices[j - 1]]) {
                listToGlob = globAdjacentZones(listToGlob, positiveIndices[j - 1], positiveIndices[j], negativeBoundary)
            }
        }

        // Gotta check if the wrap around is true as well
        // We globbed above, so gotta recheck for positive indices and then check for the 0 -> end case
        positiveIndices.clear()
        for (j in listToGlob.indices) {
            if (listToGlob[j] >= 0) {
                positiveIndices.add(j)
            }
        }
        val initialListNegativeBoundary = listToGlob.subList(0, listToGlob[positiveIndices[0]]).sum()
        val finalListNegativeBoundary = if (positiveIndices.last() == listToGlob.size - 1) 0 else listToGlob.subList(positiveIndices.last(), listToGlob.size - 1).sum()
        val totalWrapAroundNegativeBoundary = initialListNegativeBoundary + finalListNegativeBoundary
        if (totalWrapAroundNegativeBoundary <= listToGlob[positiveIndices.first()] && totalWrapAroundNegativeBoundary <= listToGlob[positiveIndices.last()]) {
            listToGlob[positiveIndices.first()] += listToGlob[positiveIndices.last()] + totalWrapAroundNegativeBoundary
            for (j in positiveIndices.last() until listToGlob.size) {
                listToGlob.removeAt(j)
            }
            for (j in 0..positiveIndices.first()) {
                listToGlob.removeAt(j)
            }
        }

        for (j in listToGlob.indices) {
            if (listToGlob[j] > maximumSeen) {
                maximumSeen = listToGlob[j]
            }
        }

        return maximumSeen
    }

    private fun globAdjacentZones(
        listToGlob: LinkedList<Int>,
        zoneIndex1: Int,
        zoneIndex2: Int,
        negativeBoundary: Int
    ): LinkedList<Int> {
        listToGlob[zoneIndex1] += listToGlob[zoneIndex2] + negativeBoundary
        for (i in zoneIndex2 downTo zoneIndex1 + 1) {
            listToGlob.removeAt(i)
        }
        return listToGlob
    }

    private fun globAdjacentIntegers(listToGlob: LinkedList<Int>, index: Int): LinkedList<Int> {
        if (listToGlob[index] < 0) return listToGlob
        var newList = LinkedList(listToGlob)
        // Look to both the 'left' and the 'right' of this index until we get to a negative number
        // For each non-negative number, remove that number and add it to the current index
        var i = index

        var nextLeft = if (i == 0) newList.size - 1 else i - 1

        while (newList[nextLeft] >= 0 && i != nextLeft) {
            newList[i] = newList[i] + newList[nextLeft]
            newList.removeAt(nextLeft)
            if (nextLeft < i) i-- //decrement i to keep it up to date
            nextLeft = if (i == 0) newList.size - 1 else i - 1
        }

        var nextRight = if (i == newList.size - 1) 0 else i + 1

        while (newList[nextRight] >= 0 && i != nextRight) {
            newList[i] = newList[i] + newList[nextRight]
            newList.removeAt(nextRight)
            nextRight = if (i == newList.size - 1) 0 else i + 1
        }

        return newList
    }
}

fun main(args: Array<String>) {
    val sol = Solution15()
//    println(sol.maxSubarraySumCircular(intArrayOf(1,-2,3,-2))) // 3
//    println(sol.maxSubarraySumCircular(intArrayOf(5,-3,5))) // 10
//    println(sol.maxSubarraySumCircular(intArrayOf(3,-1,2,-1))) // 4
//    println(sol.maxSubarraySumCircular(intArrayOf(3,-2,2,-3 ))) // 3
//    println(sol.maxSubarraySumCircular(intArrayOf(-2,-3,-1))) // -1
//    println(sol.maxSubarraySumCircular(intArrayOf(3,1,3,2,6))) // 15
//    println(sol.maxSubarraySumCircular(intArrayOf(7,9,-8,3,-5))) // 16
    println(sol.maxSubarraySumCircular(intArrayOf(-2,4,-5,4,-5,9,4))) // 15

}