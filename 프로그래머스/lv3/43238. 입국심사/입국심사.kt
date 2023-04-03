import kotlin.math.*;

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 100000000000000000L
        
        var start = 0L
        var end = answer
        
        while(true) {
            var center = (start + end) / 2
            var people = getPeople(center, times)
            if(people >= n.toLong()){
                if(getPeople(center - 1, times) < n.toLong()) return center
                end = center - 1
            }
            else start = center + 1
        }        
        
        return answer
    }
    
    fun getPeople(time: Long, times: IntArray): Long {
        var answer = 0L
        
        times.forEach {
            answer += (time/it)
        }
        
        return answer
    }
}