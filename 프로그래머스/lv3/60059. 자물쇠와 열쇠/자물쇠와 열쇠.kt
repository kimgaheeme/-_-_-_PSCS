class Solution {
    
    var lockSize = 0
    
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var N = lock.size
        var M = key.size
        
        lock.forEach {
            it.forEach { num ->
                if(num == 0) lockSize++
            }
        }
        
        if(lockSize == 0) return true
        var keys = Array(M) { IntArray(M){ 0 }}
        key.forEachIndexed { i, it ->
            it.forEachIndexed { j, num ->
                keys[i][j] = num
            }
        }
        
        repeat(4) {
            for(i in 0 until N + M - 1) {
                for(j in 0 until N + M - 1) {
                    if(isRight(i, j, keys, N, M, lock)) return true
                }
            }
            var beforeKey = Array(M) { IntArray(M){ 0 }}
            keys.forEachIndexed { i, it ->
                it.forEachIndexed { j, num ->
                    beforeKey[i][j] = num
                }
            }
            beforeKey.forEachIndexed { i, it ->
                it.forEachIndexed { j, num ->
                    keys[i][j] = beforeKey[j][M - 1 - i]
                }
            }
        }
        
        return false
    }
    
    fun isRight(x: Int, y: Int, key: Array<IntArray>, N: Int, M: Int, lock: Array<IntArray>): Boolean {
        
        var startX = if(x >= M) 0 else M - 1 - x
        var endX = if(x >= N) M - (x + 2 - N) else M - 1
        
        var startLockX = if(x >= M) N - (endX - startX) - 1 else 0
        var startLockY = if(y >= M) 0 else N - y - 1
        
        var startY = if(y < N) 0 else y - N + 1
        var endY = if(y < M) y else M - 1
        
        var count = 0
        
        for(j in 0 .. endY - startY) {
            for(i in 0 .. endX - startX) {
                if(key[startY + j][startX + i] +
                        lock[startLockY + j][startLockX + i] != 1) return false
                else if(lock[startLockY + j][startLockX + i] == 0) {
                    count++
                }
            }
        }
        return count == lockSize
    }
}