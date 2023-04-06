import java.util.*
import kotlin.math.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        var m = mutableMapOf<Int, List<Int>>()
        
        edge.forEach {
            var list0 = m.getOrDefault(it[0], listOf<Int>())
            var list1 = m.getOrDefault(it[1], listOf<Int>())
            m.put(it[0], list0.plus(it[1]))
            m.put(it[1], list1.plus(it[0]))
        }
        
        var visited = BooleanArray(n + 1){ false }
        var count = IntArray(n + 1){ 0 }
        var queue = LinkedList<Point>()
        queue.add(Point(1, 0))
        
        while(queue.size != 0) {
            var now = queue.poll()
            var v = now.v + 1
            visited[now.point] = true
            
            m.getOrDefault(now.point, listOf<Int>()).forEach { p ->
                if(!visited[p]) {
                    queue.add(Point(p, v))
                    count[p] = v
                    visited[p] = true
                }
            }
        }
        
        var ma = count.maxOrNull()!!
        count.forEach {
            if(it == ma) answer++
        }
        
        
        return answer
    }
}

data class Point(
    var point: Int,
    var v: Int
)