package thirtydaychallengemay

import kotlin.math.floor

/**
 * Created by aspanu on 2020-05-06.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
 */

class Solution6 {
    fun findComplement(num: Int): Int {
        // Xor with all 1s to get the complement
        var binStringForComplement = ""
        for (i in num.toString(2).indices) {
            binStringForComplement = "${binStringForComplement}1"
        }
        val xorInt = binStringForComplement.toInt(2)
        return num xor xorInt
    }

    fun firstUniqChar(s: String): Int {
        // Add every character to a 'seen' set, and then add everything to a 'seen again' set
        // Go through the string again and see if there are any characters that are in the first but not the second
        val seenAtLeastOnce = mutableSetOf<Char>()
        val seenAtLeastTwice = mutableSetOf<Char>()

        for (ch in s) {
            if (seenAtLeastOnce.contains(ch)) seenAtLeastTwice.add(ch)
            seenAtLeastOnce.add(ch)
        }

        for (i in s.indices) {
            if (!seenAtLeastTwice.contains(s[i])) return i
        }

        return -1
    }

    fun majorityElement(nums: IntArray): Int {
        // Start computing the frequencies of each, once we're more than 1/2 through the array, check to see
        // if any element frequencies are > floor(size/2), then return that immediately

        val freqMap = mutableMapOf<Int, Int>()
        val majorityElementThreshold = floor(nums.size / 2.0)

        for (i in nums.indices) {
            freqMap[nums[i]] = (freqMap[nums[i]] ?: 0) + 1

            if (freqMap[nums[i]]!! > majorityElementThreshold) return nums[i]
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val sol = Solution6()
    println(sol.findComplement(5)) // 2
    println(sol.findComplement(1)) // 0

    println(sol.firstUniqChar("leetcode")) // 0
    println(sol.firstUniqChar("loveleetcode")) // 2

    println(sol.majorityElement(intArrayOf(3,2,3))) // 3
    println(sol.majorityElement(intArrayOf(2,2,1,1,1,2,2))) // 2
}