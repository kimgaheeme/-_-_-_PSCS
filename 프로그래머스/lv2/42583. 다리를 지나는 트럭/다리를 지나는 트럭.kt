import java.util.*;

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        
        var answer = 0
        var queue = LinkedList<Int>(List(bridge_length){0})
        var totalWeight = 0
        var now = 0
        var done = 0
        
        while(done < truck_weights.size) {
            answer++
            
            var front = queue[0]
            queue.removeFirst()
            totalWeight -= front
            
            if(front != 0){
                done++
                if(done == truck_weights.size) break;
            }
            
            var truck = if(now < truck_weights.size) truck_weights[now] else 0
            
            if(totalWeight + truck <= weight) {
                totalWeight += truck
                queue.add(truck)
                if(now < truck_weights.size) now++
            }else {
                queue.add(0)
            }
        }
        
        return answer
    }
}