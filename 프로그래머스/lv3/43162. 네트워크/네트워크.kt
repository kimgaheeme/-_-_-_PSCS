import java.util.*;

class Solution {
    
    lateinit var visited: BooleanArray
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        visited = BooleanArray(n){ false }
        var queue = LinkedList<Int>()
        
        repeat(n) { start ->
            if(!visited[start]) {
                queue.add(start)
                visited[start] = true
                answer++
            }
        
            while(!queue.isEmpty()){
                var now = queue[0]
                queue.removeFirst()
                repeat(n) {
                    if(!visited[it] && computers[now][it] == 1) {
                        queue.add(it)
                        visited[it] = true
                    }
                }
            }
        }
        return answer
    }
}