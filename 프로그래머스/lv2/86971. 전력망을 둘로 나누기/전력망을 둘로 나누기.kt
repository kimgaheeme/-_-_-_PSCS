import java.util.*
import kotlin.math.*

class Solution {
    
    var answer: Int = 100
    var link = mutableMapOf<Int, MutableList<Int>>()
    
    fun solution(n: Int, wires: Array<IntArray>): Int {
        
        //map만들기
        wires.forEach {
            var list1 = link.getOrDefault(it[0], mutableListOf<Int>())
            var list2 = link.getOrDefault(it[1], mutableListOf<Int>())
            list1.add(it[1])
            list2.add(it[0])
            
            link.put(it[0], list1)
            link.put(it[1], list2)

        }
        
        println(link)
        
        wires.forEach { getDiff(it, n) }
        
        return answer
    }
    
    fun getDiff(wire: IntArray, n: Int) {
        var queue = LinkedList<Int>()
        var visited = BooleanArray(n){ false }
        queue.add(1)
        visited[0] = true
        var count = 0
        
        
        while(queue.size != 0) {
            var now = queue[0]
            count++
            queue.removeFirst()
            
            link.getOrDefault(now, mutableListOf<Int>()).forEach {
                if(!visited[it - 1] && !(now == wire[0] && it == wire[1]) && !(now == wire[1] && it == wire[0])) {
                    //println("$now $it  ${wire[0]}  ${wire[1]}")
                    queue.add(it)
                    visited[it - 1] = true
                }
            }
            
        }
        
        
        
        var diff = n - count
        
        if(abs(diff - count) < answer) {
            answer = abs(diff - count)
            //println("$diff  $count")
        }
    }
}