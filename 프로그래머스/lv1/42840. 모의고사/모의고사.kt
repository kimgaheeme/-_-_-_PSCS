import kotlin.math.*

class Solution {
    
    var candidate2 = intArrayOf(1,3,4,5)
    var candidate3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
    
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        var count = intArrayOf(0, 0, 0)
        
        answers.forEachIndexed { index, it ->
            var answer1 = (index) % 5 + 1
            var answer2 = if(index % 2 == 0) 2 else candidate2[index / 2 % 4]
            var answer3 = candidate3[index % 10]
            
            if(answer1 == it) count[0]++
            if(answer2 == it) count[1]++
            if(answer3 == it) count[2]++
        }
        
    
        
        var m = count.maxOrNull()!!
        if(m == 0) return answer
        
        count.forEachIndexed { index, it ->
            if( it == m) answer += (index + 1)
        }
        
        return answer
    }
}