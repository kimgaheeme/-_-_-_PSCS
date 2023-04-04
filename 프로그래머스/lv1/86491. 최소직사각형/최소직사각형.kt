import kotlin.math.*;

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var pair = Pair(sizes[0][0], sizes[0][1])
        var answer: Int = pair.first * pair.second
        
        sizes.forEach {
            var sum1 = listOf(pair.first, it[0]).maxOrNull()!! * listOf(pair.second, it[1]).maxOrNull()!!
            var sum2 = listOf(pair.first, it[1]).maxOrNull()!! * listOf(pair.second, it[0]).maxOrNull()!!
            
            if( sum1 > sum2) {
                pair = Pair(listOf(pair.first, it[1]).maxOrNull()!!, listOf(pair.second, it[0]).maxOrNull()!!)
                answer = sum2
            } else {
                pair = Pair(listOf(pair.first, it[0]).maxOrNull()!!, listOf(pair.second, it[1]).maxOrNull()!!)
                answer = sum1
            }
        }
        
        return answer
    }
}