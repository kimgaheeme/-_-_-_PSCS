import java.util.*;

class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""
        var list = PriorityQueue<String>(
            Comparator{ a, b -> 
                if((a + b).toInt() < (b + a).toInt()) 1 
                else if((a + b).toInt() == (b + a).toInt()) 0
                else -1}
        )
        
        numbers.forEach{ list.add(it.toString()) }
        
        repeat(numbers.size) {
            answer += list.poll()
        }
        
        if(answer[0] == '0') return "0"
        return answer
    }
    
}