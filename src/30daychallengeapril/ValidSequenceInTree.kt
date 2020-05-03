package `30daychallengeapril`

/**
 * Created by aspanu on 2020-04-30.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/
 */

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
}

class Solution30 {
    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        // Do DFS, checking at each level that the intArray is correct with the val at that level
        // If the intArray is done, check that this is a leaf node
        return dfsSearchForArray(arr, 0, root)
    }

    private fun dfsSearchForArray(arr: IntArray, i: Int, node: TreeNode?): Boolean {
        if (node == null) return false
        if (i >= arr.size) return false
        if (node.`val` != arr[i]) return false
        if (node.`val` == arr[i] && (i + 1 == arr.size) && (node.left != null || node.right != null)) return false
        if (node.`val` == arr[i] && (i + 1 == arr.size)) return true

        return dfsSearchForArray(arr, i+1, node.left) || dfsSearchForArray(arr, i+1, node.right)
    }
}

fun main(args: Array<String>) {
    val nodeLeaf1 = TreeNode(0)
    val nodeLeaf2 = TreeNode(0)
    val nodeLeaf3 = TreeNode(1)
    val nodeLeaf4 = TreeNode(0)
    val nodeIntermediate1 = TreeNode(1)
    val nodeIntermediate2 = TreeNode(0)
    val nodeIntermediate3 = TreeNode(0)
    nodeIntermediate1.left = nodeLeaf1
    nodeIntermediate1.right = nodeLeaf2
    nodeIntermediate2.right = nodeLeaf3
    nodeIntermediate3.left = nodeLeaf4
    val nodeRootChild1 = TreeNode(1)
    nodeRootChild1.left = nodeIntermediate2
    nodeRootChild1.right = nodeIntermediate1
    val nodeRoot = TreeNode(0)
    nodeRoot.left = nodeRootChild1
    nodeRoot.right = nodeIntermediate3

    val sol = Solution30()
    println(sol.isValidSequence(nodeRoot, intArrayOf(0,1,0,1))) // True
    println(sol.isValidSequence(nodeRoot, intArrayOf(0, 0, 1))) // False
    println(sol.isValidSequence(nodeRoot, intArrayOf(0, 1, 1))) // False
}