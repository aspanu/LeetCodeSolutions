package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-09.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
 */
class Solution9 {
    fun backspaceCompare(S: String, T: String): Boolean {
        val s = processInputString(S)
        val t = processInputString(T)
        return s == t
    }

    private fun processInputString(inputString: String): String {
        var tempString = ""
        for (character in inputString) {
            tempString = if (character == '#') {
                tempString.dropLast(1)
            } else {
                tempString.plus(character)
            }
        }
        return tempString
    }
}

fun main(args: Array<String>) {
    val sol = Solution9()
    println(sol.backspaceCompare("ab#c", "ad#c"))
    println(sol.backspaceCompare("ab##", "c#d#"))
    println(sol.backspaceCompare("a##c", "#a#c"))
    println(sol.backspaceCompare("a#c", "b"))
}
