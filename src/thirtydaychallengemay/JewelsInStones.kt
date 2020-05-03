package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-03.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
 */


class Solution2 {
    fun numJewelsInStones(J: String, S: String): Int {
        // Add all characters in J to a set, go through all characters in S and add 1 if they are in jewel set
        val jewelSet = mutableSetOf<Char>()
        for (jewel in J) {
            jewelSet.add(jewel)
        }

        var numJewels = 0
        for (stone in S) {
            if (jewelSet.contains(stone)) numJewels++
        }
        return numJewels
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        // Keep track of ransom note in map of char -> num
        // Each time a magazine letter is pulled out, check if it is ransom note, if it is, then take away 1
        // from the number of letters left to fulfill
        // Check to see if can remove the letter that you just decremented the number of, if can, check to see if can
        // stop because ransom note is done

        if (ransomNote.isEmpty()) return true

        val ransomNoteFrequencies = mutableMapOf<Char, Int>()
        for (ransomChar in ransomNote) {
            ransomNoteFrequencies[ransomChar] = (ransomNoteFrequencies[ransomChar] ?: 0) + 1
        }

        for (letter in magazine) {
            if (!ransomNoteFrequencies.containsKey(letter)) continue

            if (ransomNoteFrequencies[letter] == 1) ransomNoteFrequencies.remove(letter)
            else ransomNoteFrequencies[letter] = (ransomNoteFrequencies[letter] ?: 0) - 1

            if (ransomNoteFrequencies.isEmpty()) return true
        }

        return false
    }
}


fun main(args: Array<String>) {
    val sol = Solution2()
    println(sol.numJewelsInStones("aA", "aAAbbbb")) // 3
    println(sol.numJewelsInStones("z", "ZZ")) // 0

    println(sol.canConstruct("a", "b")) // false
    println(sol.canConstruct("aa", "ab")) // false
    println(sol.canConstruct("aa", "aab")) // true
}