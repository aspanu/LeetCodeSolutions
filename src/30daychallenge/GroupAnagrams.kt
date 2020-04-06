package `30daychallenge`

/**
 * Created by aspanu on 2020-04-06.
 */



class Solution6 {
    val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // Make a map that will be hash to list of words that are similar
        // The key will be a hash function that returns the same value for each anagram
        var hashMutableMap = mutableMapOf<Int, MutableList<String>>()
        for (word in strs) {
            val hash = getAnagramHash(word)
            if (!hashMutableMap.containsKey(hash)) {
                hashMutableMap[hash] = mutableListOf()
            }
            hashMutableMap[hash]!!.add(word)
        }
        return hashMutableMap.values.toList()
    }

    private fun getAnagramHash(word: String): Int {
        var hash = 1
        for (character in word) {
            hash *= primes[character.toInt() - 'a'.toInt()]
        }
        return hash
    }
}

fun main(args: Array<String>) {
    val sol = Solution6()
    println(sol.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    println(sol.groupAnagrams(arrayOf("eat", "tan", "bat")))
    println(sol.groupAnagrams(arrayOf("eat", "tea", "ate")))
}
