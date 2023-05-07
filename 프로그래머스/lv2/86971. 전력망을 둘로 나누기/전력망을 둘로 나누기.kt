import java.util.*
import kotlin.math.*

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        var m = mutableMapOf<Int, MutableList<Int>>()
        
        wires.forEach {
            var list1 = m.getOrDefault(it[0],mutableListOf<Int>())
            var list2 = m.getOrDefault(it[1],mutableListOf<Int>())
            list1.add(it[1])
            list2.add(it[0])
            
            m.put(it[0], list1)
            m.put(it[1], list2)
        }
        
        wires.forEach {
            var num = getNum(m, n, it[0], it[1])
            if(abs(n - num - num) < answer) answer = abs(n - num - num)
        }
        
        return answer
    }
    
    fun getNum(wires: MutableMap<Int, MutableList<Int>>, size: Int, start: Int, end: Int): Int {
        var queue = LinkedList<Int>()
        var visited = BooleanArray(size + 1){ false }
        var count = 0
        queue.add(1)
        
        while(queue.size != 0) {
            var now = queue.poll()
            visited[now] = true
            count++
            
            wires.getOrDefault(now, mutableListOf<Int>()).forEach {
                if(!visited[it] &&
                        (now != start || it != end) && (it != start || now != end)) queue.add(it)
            }
        }
        
        return count
    }
}