package `30daychallenge`

/**
 * Created by aspanu on 2020-04-19.
 */

class Solution19 {

    // Going to use the solution here instead: https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/309127/Binary-search-solution-using-kotlin!!!
    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty())return -1
        val minIndex = findMinIndex(nums)
        if(target==nums[minIndex])return minIndex
        var lo = if(target>=nums[0])0 else minIndex
        var hi = if(target>nums[nums.size-1])minIndex else nums.size-1
        while(lo<hi){
            var mid = (lo+hi)/2
            if(nums[mid]==target)return mid
            else if(target>nums[mid])lo=mid+1
            else hi=mid
        }
        return if(nums[lo]==target) lo else -1
    }

    private fun findMinIndex(nums: IntArray): Int{
        var lo = 0
        var hi = nums.size-1
        while(lo<hi){
            val mid = (lo+hi)/2
            if(nums[mid]>nums[hi])lo = mid+1
            else hi=mid
        }
        return lo
    }


//    fun search(nums: IntArray, target: Int): Int {
//        // Rotated matters only a little bit. New rules:
//        // If target > arrayNum and startNum < arrayNum, go left
//        // If target > arrayNum and startNum > arrayNum, go right
//        // If target < arrayNum, go right
//        // Always take the abs mod when one 'goes' in a direction
//
//        if (nums.isEmpty()) return -1
//
//        val stepSize = nums.size
//        val currentIndex = 0
//        val startNum = nums[0]
//
//        return rotatedBinSearch(nums, target, startNum, currentIndex, stepSize)
//    }
//
//    private fun rotatedBinSearch(nums: IntArray, target: Int, startNum: Int, currentIndex: Int, lastStepSize: Int): Int {
//        println("Current index: $currentIndex, step size: $lastStepSize, current val: ${nums[currentIndex]}")
//        if (target == nums[currentIndex]) return currentIndex
//        if (lastStepSize == 1) return -1
//
//        val goRight = nums[currentIndex] > target  && nums[currentIndex] > startNum
//
//        val nextStepSize = ceil(lastStepSize / 2.0).toInt()
//        val nextIndex = if (goRight) (currentIndex + nextStepSize) % nums.size
//            else abs((currentIndex - nextStepSize) % nums.size)
//
//        return rotatedBinSearch(nums, target, startNum, nextIndex, nextStepSize)
//    }

}
fun main(args: Array<String>) {
    val sol = Solution19()
    println(sol.search(intArrayOf(4,5,6,7,0,1,2), 0))
    println(sol.search(intArrayOf(4,5,6,7,0,1,2), 3))
    println(sol.search(intArrayOf(1,3,5), 3))
}