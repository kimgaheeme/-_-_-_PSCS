class Solution {
    
    lateinit var visited: BooleanArray
    var max = 0
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        visited = BooleanArray(dungeons.size){ false }
        
        dfs(0, k, dungeons)
        return max
    }
    
    fun dfs(count: Int, nowK: Int, dungeons: Array<IntArray>) {
        if(max < count) max = count
        
        if(count == dungeons.size || nowK <= 0) {
            return
        }
        
        repeat(dungeons.size) {
            if(!visited[it] && dungeons[it][0] <= nowK) {
                visited[it] = true
                dfs(count + 1, nowK - dungeons[it][1], dungeons)
                visited[it] = false
            }
        }
    }
}