import kotlin.math.*
class Solution {
    fun solution(answers: IntArray): IntArray {
        var n2 = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        var n3 = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    
        var count = intArrayOf(0, 0, 0)
        var answer = intArrayOf()
        
        answers.forEachIndexed { index , it ->
            if(index % 5 + 1 == it ) count[0]++
            if(it == n2[index % 8]) count[1]++
            if(it == n3[index % 10]) count[2]++
        }
        
        
        var m = count.maxOrNull()!!
        repeat(3) {
            if(count[it] == m) answer += (it + 1)
        }
        
        return answer
    }
}