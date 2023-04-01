class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var list = citations.toList().sortedDescending()
            
        repeat(list.size) {
            if( list.size - it <= list[list.size - it -1] )  return list.size - it
        }
        
        return answer
    }
}

