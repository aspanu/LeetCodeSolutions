package thirtydaychallengemay

/**
 * Created by aspanu on 2020-05-07.
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 */

 class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }

class Solution7 {
    private var xDepth = -1
    private var yDepth = -1
    private var xParent = -1
    private var yParent = -1

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        // Figure out the depth of x and y and then compare them.
        // Do DFS and keep track of whether we have found the depth of x and y
        return dfsForDepth(root, 0, x, y, 0)
    }

    private fun dfsForDepth(currentNode: TreeNode?, parentNode: Int, x: Int, y:Int, currentDepth: Int): Boolean {
        if (currentNode == null) return false
        if (currentNode.`val` == x) {
            xDepth = currentDepth
            xParent = parentNode
        } else if (currentNode.`val` == y) {
            yDepth = currentDepth
            yParent = parentNode
        }

        if (xDepth != -1 && xDepth == yDepth) return xParent != yParent

        return dfsForDepth(currentNode.left, currentNode.`val`, x, y, currentDepth + 1) ||
                dfsForDepth(currentNode.right, currentNode.`val`, x, y, currentDepth + 1)
    }
}

fun main(args: Array<String>) {
//    val node5 = TreeNode(5)
//    val node4 = TreeNode(4)
//    val node3 = TreeNode(3)
//    val node2 = TreeNode(2)
//    val root = TreeNode(1)
//    root.left = node2
//    root.right = node3
//    node2.right = node4
//    node3.right = node5

    val sol = Solution7()
//    println(sol.isCousins(root, 4, 5)) // true

    val node01 = TreeNode(1)
    val node02 = TreeNode(2)
    val node03 = TreeNode(3)
    val node04 = TreeNode(4)
    node01.left = node02
    node01.right = node03
    node02.right = node04
    println(sol.isCousins(node01, 2, 3)) // false
}