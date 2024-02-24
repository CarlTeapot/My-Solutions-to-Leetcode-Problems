import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    println(trap(intArrayOf(4,2,0,3,2,5)))
    println(trap(intArrayOf(2,0,3)))
}
fun trap(height: IntArray):Int  {

    return getArea(height,0,height.size-1, '-')+ getArea(height,0,height.size-1, '+')- getArea(height,0,height.size-1, 'x')

}

fun getArea(height: IntArray,
            start: Int,
            end: Int,
            symbol: Char): Int {
    if (end - start ==1)
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
    for (i in min(firstIndex ,secondIndex)+ 1..<max(secondIndex,firstIndex)) {
        area -= height[i]
    }

//    println("first: $first")
//    println("second: $second")
//    println("firstIndex: $firstIndex")
//
//    println("secondIndex: $secondIndex")
//    println("area: $area")
    return if (symbol == '-')
        area + getArea(height,0, min(firstIndex,secondIndex), '-');
    else if (symbol == '+') {
        area + getArea(height, max(firstIndex, secondIndex), height.size - 1, '+');
    }
    else
        area;
}
