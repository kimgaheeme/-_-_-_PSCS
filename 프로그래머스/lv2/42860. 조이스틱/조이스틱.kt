import java.util.*
import kotlin.math.*

class Solution {
    
    var targetCount = 0
    lateinit var visited: BooleanArray
    var min = Int.MAX_VALUE
    
    fun solution(name: String): Int {
        visited = BooleanArray(name.length){ false }
        name.forEachIndexed { index, it ->
            if(it != 'A') {
                targetCount++
            }else {
                visited[index] = true
            }
        }
        visited[0] = true
        
        dfs(if(name[0] != 'A') 1 else 0, 0, getVerti(name[0]), name)
        
        
        return min
    }
    
    fun dfs(depth: Int, start: Int, selected: Int, name: String) {
        
        
        if(depth == targetCount) {
            if(min > selected) min = selected
            return 
        }
        
        repeat(name.length) {
            if(!visited[it]) {
                visited[it] = true
                dfs(depth + 1, it, selected + getCount(name[it], start, it, name.length), name)
                visited[it] = false
            }
        }
        
    }
    
    
    fun getHori(start: Int, end: Int, length: Int): Int {
        var min = listOf(start, end).minOrNull()!!
        var max = listOf(start, end).maxOrNull()!!
        
        var left = max - min
        var right = length + min - max
        
        return listOf(left, right).minOrNull()!!
    }
    
    fun getVerti(c: Char): Int {
        var v = c - 'A'
        
        return listOf(v, 26 - v).minOrNull()!!
    }
    
    fun getCount(c: Char, start: Int, end: Int, length: Int): Int {
        return getVerti(c) + getHori(start, end, length)
    }
}