package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-10.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
 */

class Solution10 {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        // Build a map -> set of 'trusted by' and a set of 'people who trust'
        // Go through the keys of the trusted by map and see if their set is == N - 1, if it is and that key does not
        // trust anyone else, then return that key, otherwise, keep going
        if (N == 1 && trust.isEmpty()) return 1

        val trustedBy = mutableMapOf<Int, MutableSet<Int>>()
        val peopleThatTrust = mutableSetOf<Int>()
        for (trustArray in trust) {
            if (!trustedBy.containsKey(trustArray[1])) trustedBy[trustArray[1]] = mutableSetOf()
            trustedBy[trustArray[1]]?.add(trustArray[0])
            peopleThatTrust.add(trustArray[0])
        }

        for (trusted in trustedBy.keys) {
            if (trustedBy[trusted]?.size ?: 0 == N - 1 && !peopleThatTrust.contains(trusted)) return trusted
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val sol = Solution10()
    println(sol.findJudge(2, arrayOf(intArrayOf(1, 2)))) // 2
    println(sol.findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))) // 3
    println(sol.findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)))) // -1
    println(sol.findJudge(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))) // -1
    println(sol.findJudge(4, arrayOf(intArrayOf(1,3), intArrayOf(1,4), intArrayOf(2,3), intArrayOf(2,4), intArrayOf(4,3)))) // 3
}