class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var newLost = mutableListOf<Int>()
        var newReserve = BooleanArray(n + 1){ false }
        reserve.forEach { newReserve[it] = true }
        
        lost.forEach {
            if(newReserve[it]) {
                newReserve[it] = false
            } else {
                newLost.add(it)
            }
        }
        var count = n - newLost.size
        
        newLost.sort()
        for(i in 0 until newLost.size) {
            if(newLost[i] - 1 > 0 && newLost[i] - 1 <= n) {
                if(newReserve[newLost[i] - 1]) {
                    newReserve[newLost[i] - 1] = false
                    count++
                    continue
                }
            }
            
            if(newLost[i] + 1 > 0 && newLost[i] + 1 <= n) {
                if(newReserve[newLost[i] + 1]) {
                    newReserve[newLost[i] + 1] = false
                    count++
                }
            }
        }
        
        
        return count
    }
}