import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
//    println(trap(intArrayOf(2,0,3)))
}
fun trap(height: IntArray) = getArea(height,0,height.size-1)

fun getArea(height: IntArray,
            start: Int,
            end: Int,
            ): Int {
    if (end - start <=1)
        return 0;
    var first = 0;
    var firstIndex = 0;
    var second = 0;
    var secondIndex = 0;
    for (i in start..end) {
        if (height[i] > first) {
            second = first;
            secondIndex = firstIndex;
            first = height[i];
            firstIndex = i;
        }
        else if (height[i] > second) {
            second = height[i];
            secondIndex = i;
        }
    }
    if (first == 0 || second == 0)
        return 0;
    var area = (second * (abs(secondIndex - firstIndex) -1))
    for (i in firstIndex + 1..<secondIndex) {
        area -= height[i]
    }

    println("first: $first")
    println("second: $second")
    println("firstIndex: $firstIndex")

    println("secondIndex: $secondIndex")
    println("area: $area")
    return area + getArea(height,0, min(firstIndex,secondIndex)) +
            getArea(height,max(firstIndex,secondIndex), height.size-1);
}
