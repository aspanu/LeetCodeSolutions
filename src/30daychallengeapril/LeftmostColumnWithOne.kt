package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-21.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
 */


class BinaryMatrix(private val input: Array<IntArray>) {

    fun get(x:Int, y:Int):Int {
        return input[x][y]
    }
    fun dimensions():List<Int> {
        return listOf(input.size, input.first().size)
    }
}


class Solution21 {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        // We can do a binary search on the last row of the matrix to find the first column with a 1
        // The first column with a one will have a one on the last row no matter what (<-- wrong assumption!)
        // Turns out, that's not what row sorted binary matrix means..... POS question.
        // From hints: 2. (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner.
        // p can only move left or down. If the value at p is 0, move down.
        // If the value at p is 1, move left.
        // Try to figure out the correctness and time complexity of this algorithm.
        val sizes = binaryMatrix.dimensions()
        val rows = sizes[0]
        val cols = sizes[1]

        var currentRow = 0
        var currentCol = cols - 1
        var leftmostOneSoFar = cols

        while (currentCol > -1 && currentRow < rows) {
            val currentValue = binaryMatrix.get(currentRow, currentCol)

            if (currentValue == 0) {
                currentRow++
            } else {
                if (currentCol < leftmostOneSoFar) {
                    leftmostOneSoFar = currentCol
                }
                currentCol--
            }
        }

        return if (leftmostOneSoFar == cols) {
            -1
        } else {
            leftmostOneSoFar
        }
    }

//        val sizes = binaryMatrix.dimensions()
//        val rows = sizes[0]
//        val cols = sizes[1]
//
//        if (rows == 0 || cols == 0) {
//            return -1
//        }
//        val bottomRow = rows - 1
//
//        // Boundary case
//        if (binaryMatrix.get(bottomRow, 0) == 1) return 0
//
//        val rightCol = cols - 1
//
//        return binarySearch(binaryMatrix, rightCol, cols, bottomRow, rightCol)
//    }
//
//    private fun binarySearch(binaryMatrix: BinaryMatrix, currentIndex: Int, lastStepSize: Int, bottomRow: Int, rightCol: Int): Int {
//        val currentVal = binaryMatrix.get(bottomRow, currentIndex)
//
//        // Base cases: We are at an interface point or we are done
//        if (currentVal == 1 && currentIndex == 0) {
//            // No way to go left
//            return currentIndex
//        } else if (currentVal == 0 && currentIndex == rightCol) {
//            // No way to go right
//            return -1
//        } else if (currentVal == 0 && binaryMatrix.get(bottomRow, currentIndex + 1) == 1) {
//            return currentIndex + 1
//        } else if (currentVal == 1 && binaryMatrix.get(bottomRow, currentIndex - 1) == 0) {
//            return currentIndex
//        } else if (lastStepSize == 1) {
//            return -1
//        }
//
//        val nextStep = ceil(lastStepSize/2.0).toInt()
//        val nextIndex = if (currentVal == 1) currentIndex - nextStep
//            else currentIndex + nextStep
//
//        return binarySearch(binaryMatrix, nextIndex, nextStep, bottomRow, rightCol)
//    }

}


    fun main(args: Array<String>) {
    val sol = Solution21()
    println(sol.leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(1,1)))))
    println(sol.leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(0,1)))))
    println(sol.leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(0,0)))))
    println(sol.leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0,0,1), intArrayOf(0,0,1,1), intArrayOf(0,1,1,1)))))
    println(sol.leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(1,1,1,1,1), intArrayOf(0,0,0,1,1), intArrayOf(0,0,1,1,1), intArrayOf(0,0,0,0,1), intArrayOf(0,0,0,0,0)))))
}