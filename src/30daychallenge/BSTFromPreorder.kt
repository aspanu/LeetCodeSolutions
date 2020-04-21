package `30daychallenge`

/**
 * Created by aspanu on 2020-04-20.
 */



class Solution20 {

    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        // Add in root, then just add nodes to the BST through the normal algo
        if (preorder.isEmpty()) return null
        val root = TreeNode(preorder[0])
        for (i in 1 until preorder.size) {
            addNodeToTree(root, TreeNode(preorder[i]))
        }
        return root
    }

    private fun addNodeToTree(root: TreeNode, treeNode: TreeNode) {
        if (treeNode.`val` < root.`val` && root.left == null) root.left = treeNode
        else if (treeNode.`val` < root.`val`) addNodeToTree(root.left!!, treeNode)
        else if (treeNode.`val` > root.`val` && root.right == null) root.right = treeNode
        else if (treeNode.`val` > root.`val`) addNodeToTree(root.right!!, treeNode)
        else throw UnknownError("We hit another branch! Check that!")
    }
}

fun main(args: Array<String>) {
    val sol = Solution20()
    val root = sol.bstFromPreorder(intArrayOf(8,5,1,7,10,12))
    println(root)
}