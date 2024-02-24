fun main(args: Array<String>) {
    var list = intArrayOf(1,2,0)
    println(firstMissingPositive(list));
}

fun firstMissingPositive(nums: IntArray): Int {
    val list2 = nums.asList().toMutableList();
    var list = mutableListOf<Int>();
    for (num in list2.indices) {
        if (list2[num] > 0) {
            list.add(list2[num])
        }
    }
    if (list.isEmpty())
        return 1;
    heapSort(list);
    var current = list[0];
    if (current > 1)
        return 1;
    for (num in list) {
        if (num - current >= 2)
            return current+1;
        else current = num;
    }

    return list[list.size-1] + 1;
}
fun heapSort(data: MutableList<Int>) {
    val n = data.size
    // Build the max heap
    for (i in (n / 2 - 1) downTo 0) {
        heapify(data, n, i)
    }
    // Extract elements one by one
    for (i in n - 1 downTo 0) {
        // Move current root to end
        swap(data, 0, i)
        // call max heapify on the reduced heap
        heapify(data, i, 0)
    }
}

private fun heapify(data: MutableList<Int>, n: Int, i: Int) {
    var largest = i // Initialize largest as root
    val left = 2 * i + 1  // left = 2*i + 1
    val right = 2 * i + 2  // right = 2*i + 2

    // See if left child of root exists and is greater than root
    if (left < n && data[left] > data[largest]) largest = left

    // See if right child of root exists and is greater than root
    if (right < n && data[right] > data[largest]) largest = right

    // Change root, if needed
    if (largest != i) {
        swap(data, i, largest)
        // Heapify the root
        heapify(data, n, largest)
    }
}

private fun swap(data: MutableList<Int>, i: Int, j: Int) {
    val temp = data[i]
    data[i] = data[j]
    data[j] = temp
}