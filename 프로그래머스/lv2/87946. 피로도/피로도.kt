import kotlin.math.*

class Solution {
    
    lateinit var visited: BooleanArray
    var max = 0
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = BooleanArray(dungeons.size){ false }
        
        dfs(arrayOf<IntArray>(), k, dungeons)
        
        return max
    }
    
    fun dfs(selected: Array<IntArray>, p: Int, dungeons: Array<IntArray>){
        if(selected.size != 0) max = listOf(max, selected.size).maxOrNull()!!
        
        repeat(dungeons.size) {
            if(!visited[it] && p >= dungeons[it][0]) {
                visited[it] = true
                dfs(selected + dungeons[it], p - dungeons[it][1], dungeons)
                visited[it] = false
            }
        }
    }
}