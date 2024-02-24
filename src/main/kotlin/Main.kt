fun main(args: Array<String>) {
    println(combinationSum(intArrayOf(2,3,5), 8).toString())
}
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>>? {
    var list = mutableListOf<Int>();
    var list2 = mutableListOf<List<Int>>();
    recursive(list,list2,candidates,target,0);
    return list2;
}

private fun recursive(
    list: MutableList<Int>,
    list2: MutableList<List<Int>>,
    candidates: IntArray,
    target: Int,
    startingIndex: Int
) {
    if (target < 0)
        return;
    else if (target == 0) {
        list2.add(list.toList())
    }
    else {
        for (i in startingIndex..< candidates.size) {
            list.add(candidates[i]);
            recursive(list,list2,candidates,target - candidates[i],i);
            list.removeAt(list.size-1);
        }
    }
}

