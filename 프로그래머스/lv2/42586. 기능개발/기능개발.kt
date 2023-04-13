import java.util.*
import kotlin.math.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var stack = Stack<Int>()
        var now = ceil((100 - progresses[0]) / speeds[0].toDouble()).toInt()
        var count = 1
        
        for(i in progresses.size - 1 downTo 1) {
            stack.push(ceil((100 - progresses[i]) / speeds[i].toDouble()).toInt())
        }
        
        while(!stack.isEmpty()) {
            if(now >= stack.peek()) {
                count++
            } else {
                now = stack.peek()
                answer += count
                count = 1 
            }
            stack.pop()
        }
        
        answer += count
        
        
        return answer
    }
}