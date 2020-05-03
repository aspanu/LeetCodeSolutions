package `30daychallengeapril`

import java.util.*
import kotlin.math.max

/**
 * Created by aspanu on 2020-04-11.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution11 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        // Find the longest length in both branches and store the sum as the value for that node
        // Go through entire tree and find the largest value

        setDepth(root, 0)

        val queue = LinkedList<TreeNode?>()
        var largestDiameter = 0
        queue.add(root)

        while (!queue.isEmpty()) {
            val node = queue.pop() ?: break
            val leftPathFromMe = getLargestDepth(node.left) - node.`val`
            val rightPathFromMe = getLargestDepth(node.right) - node.`val`
            if ((leftPathFromMe + rightPathFromMe) > largestDiameter) largestDiameter = leftPathFromMe + rightPathFromMe

            if (node.left != null) queue.add(node.left)
            if (node.right != null) queue.add(node.right)
        }

        return largestDiameter
    }

    private fun getLargestDepth(node: TreeNode?): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null) return node.`val`

        return max(getLargestDepth(node.left), getLargestDepth(node.right))
    }

    private fun setDepth(node: TreeNode, currentDepth: Int) {
        node.`val` = currentDepth
        if (node.left != null) setDepth(node.left!!, currentDepth + 1)
        if (node.right != null) setDepth(node.right!!, currentDepth + 1)
    }
}

fun main(args: Array<String>) {
    val sol = Solution11()
    val node5 = Solution11.TreeNode(5)
    val node4 = Solution11.TreeNode(4)
    val node2 = Solution11.TreeNode(2)
    node2.left = node4
    node2.right = node5
    val node3 = Solution11.TreeNode(3)
    val root = Solution11.TreeNode(1)
    root.left = node2
    root.right = node3
    println(sol.diameterOfBinaryTree(root))
}