/**
 * Created by aspanu on 2020-05-06.
 */


class Solution0 {
    // https://leetcode.com/contest/weekly-contest-187/problems/destination-city/
    // Keep track of what places have exist that don"t have a path out yet, the only one left is the answer
    fun destCity(paths: List<List<String>>): String {
        val citiesSeen = HashSet<String>(paths.size)
        val citiesWithoutAPathYet = HashSet<String>(paths.size)

        for (path in paths) {
            if (!citiesSeen.contains(path[1])) citiesWithoutAPathYet.add(path[1])
            citiesSeen.add(path[0])
            citiesWithoutAPathYet.remove(path[0])
        }

        return citiesWithoutAPathYet.first()
    }

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    // Go through each
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf()

        val numberToLetters = mapOf( 1 to listOf(), 2 to listOf("a", "b", "c"), 3 to listOf("d", "e", "f"),
            4 to listOf("g", "h", "i"), 5 to listOf("j", "k", "l"), 6 to listOf("m", "n", "o"),
            7 to listOf("p", "q", "r", "s"), 8 to listOf("t", "u", "v"), 9 to listOf("w", "x", "y", "z"), 0 to listOf())

        val toCrossProduct = digits.map { numberToLetters[it.toString().toInt()] }.toList()

        var left = toCrossProduct[0] ?: error("")
        for (i in 1 until toCrossProduct.size) {
            left = crossProduct(left, toCrossProduct[i] ?: error(""))
        }

        return left
    }

    private fun crossProduct(listOne: List<String>, listTwo: List<String>): List<String> {
        val crossProductTable = mutableListOf<String>()
        listOne.map {
                l1 -> listTwo.map {
                l2 -> crossProductTable.add("$l1$l2")
        } }
        return crossProductTable
    }
}

fun main(args: Array<String>) {
    val sol = Solution0()
    println(sol.destCity(listOf(listOf("London","New York"), listOf("New York","Lima"), listOf("Lima","Sao Paulo")))) // Sao Paulo
    println(sol.destCity(listOf(listOf("B","C"), listOf("D","B"), listOf("C","A")))) // A

    println(sol.letterCombinations("23"))
}