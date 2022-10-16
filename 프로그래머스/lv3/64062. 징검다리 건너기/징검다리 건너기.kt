class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var max = stones.maxOrNull()
        var min = stones.minOrNull()
        var center = (min!! + max!!) / 2
        
        
        while(min != center) {
            if(hasZeroPart(stones, k, center)) {
                max = center
            }else {
                min = center
            }
            center = (min!! + max!!) / 2
        }
        
        if(hasZeroPart(stones, k, min)) return min!!
        return max!!
    }
}

fun hasZeroPart(stones: IntArray, k: Int, num: Int): Boolean {
    var sum: Long = 0L
    repeat(k) {
            var back = if(stones[it] - num < 0) 0 else stones[it] - num
            sum += back
        }

        if(sum == 0L) return true
        
        var i = k
        while(stones.size > i) {
            var front = if(stones[i - k] - num < 0) 0 else stones[i - k] - num
            var back = if(stones[i] - num < 0) 0 else stones[i] - num
            sum = sum - front + back
            if(sum == 0L) return true
            i++
        }
                    
    return false
}