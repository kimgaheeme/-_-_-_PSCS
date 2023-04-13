import java.util.*
import kotlin.math.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        var answerlist = IntArray(n + 1){ 0 } 
        var visited = BooleanArray(n + 1) { false }
        
        var m = mutableMapOf<Int, MutableList<Int>>()
        edge.forEach {
            var list0 = m.getOrDefault(it[0], mutableListOf<Int>())
            var list1 = m.getOrDefault(it[1], mutableListOf<Int>())
            
            list0.add(it[1])
            list1.add(it[0])
            
            m.put(it[0], list0)
            m.put(it[1], list1)
        }
        
        var queue = LinkedList<Point>()
        queue.add(Point(1, 0))
        visited[1] = true
        
        while(queue.size != 0) {
            var now = queue.poll()
            var count = now.count + 1
            
            m.getOrDefault(now.p, mutableListOf<Int>()).forEach {
                if(!visited[it]) {
                    queue.add(Point(it, count))
                    visited[it] = true
                    answerlist[it] = count
                }
            }
        }
        
        var ma = answerlist.maxOrNull()!!
        answerlist.forEach {
            if(it == ma) answer++
        }
        
        return answer
    }
}

data class Point(
    var p: Int,
    var count: Int = 0
)