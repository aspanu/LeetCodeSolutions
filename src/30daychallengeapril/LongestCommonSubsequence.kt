package `30daychallengeapril`

import kotlin.math.max

/**
 * Created by aspanu on 2020-04-26.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3311/
 */

class Solution26 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val longestSubsequenceSoFar = Array(text1.length) {IntArray(text2.length) {0} }
        for (i in text1.indices) {
            for (j in text2.indices) {
                if (text1[i] == text2[j]) {
                    if (i == 0 || j == 0) {
                        longestSubsequenceSoFar[i][j] = 1
                    } else {
                        longestSubsequenceSoFar[i][j] = longestSubsequenceSoFar[i - 1][j - 1] + 1
                    }
                } else {
                    val left = if (i == 0) 0 else longestSubsequenceSoFar[i-1][j]
                    val up = if (j == 0) 0 else longestSubsequenceSoFar[i][j-1]
                    longestSubsequenceSoFar[i][j] = max(left, up)
                }
            }
        }
        return longestSubsequenceSoFar.last().last()
    }
}

fun main(args: Array<String>) {
    val sol = Solution26()
    println(sol.longestCommonSubsequence("abcde", "ace"))
    println(sol.longestCommonSubsequence("abcde", "aec"))
    println(sol.longestCommonSubsequence("abc", "abc"))
    println(sol.longestCommonSubsequence("abc", "def"))
}