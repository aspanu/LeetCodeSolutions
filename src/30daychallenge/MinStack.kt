package `30daychallenge`

/**
 * Created by aspanu on 2020-04-10.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3292/
 */

class MinStack() {

    /** initialize your data structure here. */
    private class Node(val value: Int) {
        var next: Node? = null
        var minValue: Int = value
    }
    private var head: Node? = null

    fun push(x: Int) {
        val newNode = Node(x)
        if (head != null && x > head!!.minValue) {
            newNode.minValue = head!!.minValue
        }

        newNode.next = head
        head = newNode
    }

    fun pop() {
        head = head?.next
    }

    fun top(): Int {
        return head?.value ?: 0
    }

    fun getMin(): Int {
        return head?.minValue ?: 0
    }

}

fun main(args: Array<String>) {
    val minStack = MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    println(minStack.getMin());  // --> Returns -3.
    minStack.pop()
    println(minStack.top())     // --> Returns 0.
    println(minStack.getMin())  // --> Returns -2.
}

