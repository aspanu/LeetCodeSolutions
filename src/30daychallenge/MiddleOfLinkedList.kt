package `30daychallenge`

import kotlin.math.floor

/**
 * Created by aspanu on 2020-04-08.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/
 */

class ListNode(var `val`: Int) {
         var next: ListNode? = null
}

class Solution8 {
    fun middleNode(head: ListNode?): ListNode? {
        val nodeArray = mutableListOf<ListNode>()

        var node = head

        while (node != null) {
            nodeArray.add(node)
            node = node.next
        }

        return if (nodeArray.size % 2 == 1) {
            nodeArray[floor(nodeArray.size / 2.0).toInt()]
        } else {
            nodeArray[(nodeArray.size / 2)]
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution8()
    val head = ListNode(1)
    val onePos = ListNode(2)
    val twoPos = ListNode(3)
    val threePos = ListNode(4)
    val fourPos = ListNode(5)
    val fivePos = ListNode(6)
    val sixPos = ListNode(7)
    head.next = onePos
    onePos.next = twoPos
    twoPos.next = threePos
    threePos.next = fourPos
    fourPos.next = fivePos
    fivePos.next = sixPos
    println(sol.middleNode(head)?.`val`)
}
