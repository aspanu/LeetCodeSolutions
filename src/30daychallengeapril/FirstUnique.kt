package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-28.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/
 */

class FirstUnique(nums: IntArray) {
    private val numSet = nums.toMutableSet()
    private val uniqueSet = uniquesOfNums(nums)

    private fun uniquesOfNums(nums: IntArray): LinkedHashSet<Int> {
        val frequencies = LinkedHashMap<Int, Int>()
        for (num in nums) {
            if (!frequencies.containsKey(num)) {
                frequencies[num] = 0
            }
            frequencies[num] = frequencies[num]!! + 1
        }

        val output = LinkedHashSet<Int>()
        for (key in frequencies.keys) {
            if (frequencies[key]!! == 1) {
                output.add(key)
            }
        }
        return output
    }

    fun showFirstUnique(): Int {
        return if (uniqueSet.isEmpty()) -1
        else uniqueSet.iterator().next()
    }

    fun add(value: Int) {
        if (!numSet.contains(value)) {
            uniqueSet.add(value)
        } else {
            uniqueSet.remove(value)
        }
        numSet.add(value)
    }
}

fun main(args: Array<String>) {
//    val firstUnique = FirstUnique(intArrayOf(2,3,5))
//    println(firstUnique.showFirstUnique()) // 2
//    firstUnique.add(5)
//    println(firstUnique.showFirstUnique()) // 2
//    firstUnique.add(2)
//    println(firstUnique.showFirstUnique()) // 3
//    firstUnique.add(3)
//    println(firstUnique.showFirstUnique()) // -1

    val firstUnique2 = FirstUnique(intArrayOf(7,7,7,7,7,7))
    println(firstUnique2.showFirstUnique()) // -1
    firstUnique2.add(7)
    firstUnique2.add(3)
    firstUnique2.add(3)
    firstUnique2.add(7)
    firstUnique2.add(17)
    println(firstUnique2.showFirstUnique()) // 17

//    val firstUnique3 = FirstUnique(intArrayOf(809))
//    println(firstUnique3.showFirstUnique()) // 809
//    firstUnique3.add(809)
//    println(firstUnique3.showFirstUnique()) // -1

}