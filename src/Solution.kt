import java.util.*

internal class Box(var left: Float, var top: Float, var width: Float, var height: Float)

internal class Solution {
    // Returns [left, top]
    // Where to move the box to either snap to the nearest axis within the threshold,
    // or the current position of the box, if the box should not snap.
    private fun getPositionToSnapTo(xAxes: FloatArray, yAxes: FloatArray, box: Box): FloatArray {
        // Your code here!
        return floatArrayOf(box.left, box.top)
    }

    // Binary searches a sorted list and returns the index of the item
    // strictly below where the value would be found.
    // Returns -1 if value is less than the first element in the list
    private fun indexOfLowerBound(list: FloatArray, value: Float): Int {
        var start = 0.0
        var stop = list.size - 1.toDouble()
        var middle = Math.floor((start + stop) / 2).toInt()
        while (start <= stop) {
            if (value <= list[middle]) {
                stop = middle - 1.toDouble()
            } else {
                start = middle + 1.toDouble()
            }
            middle = Math.floor((start + stop) / 2).toInt()
        }
        return middle
    }

    companion object {
        var SNAP_THRESHOLD = 5

        @JvmStatic
        fun main(args: Array<String>) {
            val strings = ArrayList<String>()
            strings.add("Hello, World!")
            strings.add("Welcome to CoderPad.")
            strings.add("This pad is running Java " + Runtime.version().feature())
            for (string in strings) {
                println(string)
            }
        }
    }
}