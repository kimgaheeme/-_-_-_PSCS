import java.util.*

class Solution {
    
    var map = mutableMapOf<Int, Int>()
    
    fun solution(priorities: IntArray, location: Int): Int {
        
        var answer = 0
        
        //Linked List 로 queue만들기 (0...n)
        var queue = LinkedList<Int>((0 until priorities.size).toList())
        
        //map만들기
        repeat(9) { map.put(it + 1, 0 ) }
        priorities.forEach { map.put(it, map.getOrDefault(it, 0) + 1) }
        
        while(queue.isNotEmpty()) {
            var value = priorities[queue[0]]
            if(haveLarger(value)){
                queue.add(queue[0])
                queue.removeFirst()
            }
            else if(queue[0] == location) break;
            else {
                map.put(value, map.getOrDefault(value, 0) - 1)
                queue.removeFirst()
                answer++
            }
            
        }
        
        return answer + 1
    }
    
    fun haveLarger(start: Int): Boolean {
        for(i in (start + 1) .. 9) {
            if(map[i] != 0) return true
        }
        return false
    }
}