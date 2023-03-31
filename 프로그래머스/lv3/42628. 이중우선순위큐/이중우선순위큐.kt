class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()

        operations.forEach {
            when(it[0]) {
                'I' -> {
                    answer = answer.plus(it.substringAfter("I ").toInt())
                }
                else -> {
                    if(it == "D 1") answer = deleteMax(answer)
                    else answer = deleteMin(answer)
                }
            }
        }
        return intArrayOf(answer.maxOrNull()?: 0,answer.minOrNull()?: 0)
    }
}

fun deleteMax(arr:IntArray): IntArray = if (arr.size == 1) intArrayOf()
    else { arr.filter {  x -> x != arr.maxOrNull() }.toIntArray()}

fun deleteMin(arr:IntArray): IntArray = if (arr.size == 1) intArrayOf()
    else arr.filter {  x -> x != arr.minOrNull() }.toIntArray()