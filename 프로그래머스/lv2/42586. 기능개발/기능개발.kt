import kotlin.math.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        
        var front = -1
        var count = 0
        var days = progresses
            .mapIndexed{ index, it -> ceil((100 - it) / speeds[index].toDouble()).toInt()}
            .forEach{
                if(front == -1) front = it
                
                if(front >= it) count++
                else if(front < it) {
                    front = it
                    answer += count
                    count = 1
                }
            }
        
        answer += count
        return answer
    }
}