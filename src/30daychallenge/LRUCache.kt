package `30daychallenge`

/**
 * Created by aspanu on 2020-04-24.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3309/
 */

// Note: This doesn't actually solve the problem on Leetcode since they make dumb decisions regarding edge cases
// to force someone to write their own implementation of a LinkedHashMap....
class LRUCache(private val capacity: Int) {
    // Actual cache
    private val cache = LinkedHashMap<Int, Int>(capacity)

    fun get(key: Int): Int {
        return if (cache.containsKey(key)) {
            val toReturn = cache[key] ?: throw UnknownError("Already checked that this key exists")
            cache.remove(key)
            cache[key] = toReturn
            toReturn
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (cache.size >= this.capacity) {
            val keyToRemove = cache.iterator().next().key
            if (!cache.containsKey(key) || keyToRemove == key) {
                cache.remove(keyToRemove)
            }
            // Do nothing
        }
        cache[key] = value
    }
}

fun main(args: Array<String>) {
    val cache = LRUCache(2)
    cache.put(1,1)
    cache.put(2,2)
    println(cache.get(1)) // 1
    cache.put(3,3)
    println(cache.get(2)) // -1
    cache.put(4,4)
    println(cache.get(1)) // -1
    println(cache.get(3)) // 3
    println(cache.get(4)) // 4

    val cache2 = LRUCache(2)
    cache2.put(2, 1)
    cache2.put(1, 1)
    cache2.put(2, 3)
    cache2.put(4, 1)
    println(cache2.get(1)) // -1
    println(cache2.get(2)) // 3

    val cache3 = LRUCache(2)
    cache3.get(2) // -1
    cache3.put(2, 6)
    cache3.get(1) // -1
    cache3.put(1, 5)
    cache3.put(1, 2)
    println(cache3.get(1)) // 2
    println(cache3.get(2)) // 6
}