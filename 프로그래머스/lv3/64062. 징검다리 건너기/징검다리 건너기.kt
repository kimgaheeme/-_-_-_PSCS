class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        
        var start = 0
        var end = stones.maxOrNull()!!
        var mid: Int = (start + end) / 2
        
        while(start < end) {
            if(canPass(stones, k, mid)) end = mid
            else start = mid + 1
            
            mid = (start + end) / 2
            //println("${start}, ${mid}  ${end}")
            
        }
        
        return end
    }
}

fun canPass(stones: IntArray, k: Int, n: Int): Boolean {
    var length = 0
    
    stones.forEach{
        if(it - n <= 0) length++
        else length = 0
        
        if(length == k) return true
    }
    
    return false
}