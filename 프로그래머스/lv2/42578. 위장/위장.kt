class Solution {
    fun solution(clothes: Array<Array<String>>): Int = clothes
            .groupBy { it[1] }
            .values
            .fold(1) { total, it -> total * (it.size + 1) } - 1
}
