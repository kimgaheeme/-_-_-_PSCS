class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var start = 0L
        var end = 1000000000000000000L
        
        while(true) {
            var center = (start + end) / 2
            
            if(can(center, times, n)) {
                if(!can(center - 1, times, n)) return center
                end = center - 1
            }else {
                start = center + 1
            }
        }
        
        
        return answer
    }
    
    fun can(time: Long, times: IntArray, n: Int): Boolean {
        var count = 0L
        
        times.forEach {
            count += (time / it)
        }
        
        return count >= n
    }
}