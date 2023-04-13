import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var s = 0
        var count = 0
        var now = 0
        var queue = LinkedList<Int>()
        repeat(bridge_length) { queue.add(0) }
        
        while(count != truck_weights.size) {
            answer++
            if(queue.peek() != 0) {
                count++
                if(count == truck_weights.size) break;
            }
            s -= queue.peek()
            queue.removeFirst()
            
            if(now < truck_weights.size ) {
                if(s + truck_weights[now] <= weight) {
                    s += truck_weights[now]
                    queue.add(truck_weights[now])
                    now++
                }else { queue.add(0) }
            }
            
        }
        
        return answer
    }
}