package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-14.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 */
class Solution14 {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var newString = s
        val finalShift = compressShifts(shift)
        val direction = finalShift[0]
        val amplitude = finalShift[1]
        for (i in 0 until amplitude) {
            newString = shiftStringByOne(newString, direction)
        }
        return newString
    }

    private fun compressShifts(shiftInput: Array<IntArray>): IntArray {
        var amplitudeOfLeft = 0
        var amplitudeOfRight = 0
        for (shifts in shiftInput) {
            if (shifts[0] == 0) {
                amplitudeOfLeft += shifts[1]
            } else {
                amplitudeOfRight += shifts[1]
            }
        }

        return if (amplitudeOfLeft > amplitudeOfRight) {
            intArrayOf(0, amplitudeOfLeft - amplitudeOfRight)
        } else {
            intArrayOf(1, amplitudeOfRight - amplitudeOfLeft)
        }
    }

    private fun shiftStringByOne(stringToChange: String, direction: Int): String {
        return if (direction == 0) {
            // Left
            val firstChar = stringToChange.first()
            stringToChange.drop(1) + firstChar
        } else {
            // Right
            val lastChar = stringToChange.last()
            lastChar + stringToChange.dropLast(1)
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution14()
    println(sol.stringShift("abc", arrayOf(intArrayOf(0,1), intArrayOf(1,2))))
    println(sol.stringShift("abcdefg", arrayOf(intArrayOf(1,1), intArrayOf(1,1), intArrayOf(0,2), intArrayOf(1,3))))
}