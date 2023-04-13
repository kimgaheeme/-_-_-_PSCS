class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        
        citations.sortDescending()
    
        
        for(i in citations.size downTo 1) {
            if(citations[i - 1] >= i) return i
        }
        
        return 0
    }
}