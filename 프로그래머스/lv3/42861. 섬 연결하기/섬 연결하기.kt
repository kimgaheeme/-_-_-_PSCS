import java.util.*

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        var selected = costs.toList().sortedBy{ it[2] }.toMutableList()
        var costsSize = selected.size
        
        for(i in costsSize - 1 downTo 0) {
            var now = selected[i]
            selected.removeAt(i)
            if(!isConnected(n, selected)) {
                selected.add(now)
                answer += now[2]
            }
            
        }
        
        
        
        return answer
    }
    
    fun isConnected(n: Int, selected: List<IntArray>): Boolean {
        var visited = BooleanArray(n){ false }
        var queue = LinkedList<Int>()
        var m = mutableMapOf<Int, MutableList<Int>>()
       
        selected.forEach {
            var list0 = m.getOrDefault(it[0], mutableListOf<Int>())
            var list1 = m.getOrDefault(it[1], mutableListOf<Int>())
            list0.add(it[1])
            list1.add(it[0])
            m.put(it[0], list0)
            m.put(it[1], list1)
        }
        
        queue.add(0)
        var count = 0
        visited[0] = true
        
        while(queue.size != 0) {
            var now = queue.poll()
            count++
            
            var list0 = m.getOrDefault(now, mutableListOf())
            list0.forEach {
                if(!visited[it]) {
                    queue.add(it)
                    visited[it] = true
                }
            }
            
        }
        
        if(n == count) return true
        else return false
        
    }
}

