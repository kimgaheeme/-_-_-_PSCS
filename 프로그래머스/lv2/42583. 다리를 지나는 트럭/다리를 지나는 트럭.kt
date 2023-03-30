import java.util.*;

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        
        //queue 선언 and queue 크기와 안에있는 트럭개수 변수 선언
        var queue = LinkedList<Int>()
        var totalWeight = 0
        var now = 0
        var done = 0
        
        repeat(bridge_length) { queue.add(0) }
        
        while(done < truck_weights.size) {

            answer++
            
            var front = queue[0]
            queue.removeFirst()
            
            if(front != 0){
                done++
                totalWeight -= front
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