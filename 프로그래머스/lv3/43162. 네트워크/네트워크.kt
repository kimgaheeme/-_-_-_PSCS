import java.util.*

class Solution {
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        var visited = BooleanArray(n){false}
        var queue = LinkedList<Int>()
        
        repeat(n){
            if(!visited[it]) {
                answer++
                queue.add(it)
                visited[it] = true
                
                while(queue.size != 0) {
                    var now = queue.poll()
                    
                    computers[now].forEachIndexed { index, it ->
                        if(!visited[index] && it == 1) {
                            queue.add(index)
                            visited[index] = true
                        }
                    }
                }
                
            }
        }
        
        return answer
    }
}