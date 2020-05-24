package thirtydaychallengemay

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by aspanu on 2020-05-18.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */

class Solution18 {

    data class TrieNode(val letter: Char, var child: TrieNode? = null)

    fun checkInclusion(s1: String, s2: String): Boolean {
        // Create a trie out of s2, start at the root and go down, looking to see if all of the letters of s1
        // have just been found, if not and it's a new letter, restart the looking
        if (s2.isEmpty()) return false

        val root = TrieNode(s2[0])
        var currentNode = root
        for (i in 1 until s2.length) {
            val newNode = TrieNode(s2[i])
            currentNode.child = newNode
            currentNode = newNode
        }

        val originalS1Frequency = mutableMapOf<Char, Int>()

        for (letter in s1) {
            originalS1Frequency[letter] = (originalS1Frequency[letter] ?: 0) + 1
        }

        var currentFrequencies = originalS1Frequency.toMutableMap()
        currentNode = root
        while (currentNode.child != null) {
            if (!currentFrequencies.containsKey(currentNode.letter)) {
                // Reset things
                currentFrequencies = originalS1Frequency.toMutableMap()
            } else {
                if (currentFrequencies[currentNode.letter]!! > 0) {
                    currentFrequencies[currentNode.letter] = (currentFrequencies[currentNode.letter] ?: 0) - 1
                    if (currentFrequencies.values.sum() == 0) return true
                }
            }
            currentNode = currentNode.child ?: error("Shouldn't have hit it.")
        }

        if (currentFrequencies.containsKey(currentNode.letter)) {
            if (currentFrequencies[currentNode.letter]!! > 0) {
                currentFrequencies[currentNode.letter] = (currentFrequencies[currentNode.letter] ?: 0) - 1
                if (currentFrequencies.values.sum() == 0) return true
            } else {
                return false
            }
        }

        return false
    }
}

fun main(args: Array<String>) {
    val sol = Solution18()
    assertTrue(sol.checkInclusion("ab", "eidbaooo"))
    assertFalse(sol.checkInclusion("ab", "eidboaoo"))
}