import kotlin.math.*

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var minNum = 0
        var maxNum = 0
        
        sizes.forEach {
            var mi = it.minOrNull()!!
            var ma = it.maxOrNull()!!
            
            if(minNum < mi) minNum = mi
            if(maxNum < ma) maxNum = ma
        }
        
        return minNum * maxNum
    }
}