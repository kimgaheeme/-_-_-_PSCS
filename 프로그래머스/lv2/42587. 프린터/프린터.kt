import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var pq = PriorityQueue<Int>(Comparator{ a, b -> b - a})
        var queue = LinkedList<Point>()
        
        for(i in 0 until priorities.size) {
            pq.add(priorities[i])
            queue.add(Point(priorities[i], i))
        }
        
        while(queue.size != 0) {
            if(pq.peek() == queue[0].pri) {
                if(queue[0].location == location) return answer + 1
                pq.poll()
                queue.removeAt(0)
                answer++
                
            } else {
                queue.add(queue[0])
                queue.removeAt(0)
            }
        }
        
        return answer
    }
}

data class Point(
    var pri: Int,
    var location: Int
)