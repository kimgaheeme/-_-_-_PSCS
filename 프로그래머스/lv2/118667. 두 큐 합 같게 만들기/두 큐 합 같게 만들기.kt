class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        
        var queue = queue1 + queue2
        var p1 = 0
        var p2 = queue1.size
        
        var half:Long = 0
        var answer: Int = 0
        
        queue1.forEach{
            half += it
        }
        
        var sum:Long = half
        queue2.forEach{
            sum += it
        }
        
        while(answer < (600000)) {
            if(half == sum / 2) return answer
            if(half > sum / 2) {
                half -= queue[p1++]
                if(p1 >= queue.size) p1 = 0
            } else {
                half += queue[p2++]
                if(p2 >= queue.size) p2 = 0
            }
            answer++
            if(p1==p2) return -1
        }
        
        
        return -1
    }
}