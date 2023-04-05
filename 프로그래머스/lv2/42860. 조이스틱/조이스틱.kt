import kotlin.math.*

class Solution {
    
    lateinit var visited: BooleanArray
    var min = 500
    var s = ""
    
    fun solution(name: String): Int {
        s = name
        var list = mutableListOf<Int>()
        if(name[0] == 'A') list.add(0)
        name.forEachIndexed { index, it ->
            if(it != 'A') list.add(index)
        }
        visited = BooleanArray(list.size){ false }
        visited[0] = true
        
        dfs(1, list, 0, 0)
        
        return min
    }
    
    fun dfs(selected: Int, list: MutableList<Int>, count: Int, start: Int) {
        var total = count +  getCount(s[start])
        //println("selected: $selected  start: $start total: $total")
        
        if(selected == list.size) {
            if(min > total) min = total
            return
        }
        
        else {
            repeat(list.size) {
                if(!visited[it]) {
                    visited[it] = true
                    dfs(selected + 1, list, total + getLength(start, list[it]), list[it])
                    visited[it] = false
                }
            }
        }
    }
    
    fun getLength(st: Int, e: Int): Int {
        var start = listOf(st, e).minOrNull()!!
        var end = listOf(st, e).maxOrNull()!!
        
        var left = abs(start + s.length - end)
        var right = abs(end - start)
        
        if(right > left) return left
        else return right
    }
    
    fun getCount(c: Char): Int {
        var num = c - 'A'
        if(num > (26 - num)) return 26 - num
        else return num
    }
}