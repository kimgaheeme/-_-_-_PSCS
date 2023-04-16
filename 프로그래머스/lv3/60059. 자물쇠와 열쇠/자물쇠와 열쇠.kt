class Solution {
    
    var lockSize = 0
    
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var N = lock.size
        var M = key.size
        
        lock.forEach { it.forEach { num -> if(num == 0) lockSize++ } }
        
        var keys = Array(M) { IntArray(M){ 0 }}
        key.forEachIndexed { i, it ->
            it.forEachIndexed { j, num ->
                keys[i][j] = num
            }
        }
        
        var locks = Array(N + 2 * M -2){ Array<Point>(N + 2 * M -2){Point()}}
        
        repeat(N) { y ->
            repeat(N) { x ->
                locks[y + M - 1][x + M - 1].isIn = true
                locks[y + M - 1][x + M - 1].v = lock[y][x]
            }
        }
        
        
        repeat(4) {
            for(i in 0 until N + M - 1) {
                for(j in 0 until N + M - 1) {
                    if(isRight(i, j, keys, N, M, locks)) return true
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
    
    fun isRight(dx: Int, dy: Int, key: Array<IntArray>, N: Int, M: Int, lock: Array<Array<Point>>): Boolean {
        
        var count = 0
        repeat(M) { x ->
            repeat(M) { y ->
                if(lock[dx + x][dy + y].isIn) {
                    if(lock[dx + x][dy + y].v + key[x][y] != 1) return false
                    else if(lock[dx + x][dy + y].v == 0) count++
                }
            }
        }
        
        return count == lockSize
    }
    
}

data class Point(
    var isIn: Boolean = false,
    var v: Int = 0
)