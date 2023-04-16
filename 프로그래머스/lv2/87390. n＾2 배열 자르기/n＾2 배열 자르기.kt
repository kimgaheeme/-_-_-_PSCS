import kotlin.math.*

class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()
        
        (left .. right).forEach {
            var y = it / n
            var x = it - n * y
            answer += listOf(x + 1, y + 1).maxOrNull()!!.toInt()
        }
        return answer
    }
}