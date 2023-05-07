import java.util.*

class Solution {
    
    lateinit var loseLink: Array<BooleanArray>
    lateinit var winLink: Array<BooleanArray>
    
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        
        loseLink = Array(n + 1){ BooleanArray(n + 1){ false } }
        winLink = Array(n + 1){ BooleanArray(n + 1){ false } }
        results.forEach {
            winLink[it[0]][it[1]] = true
            loseLink[it[1]][it[0]] = true
        }
        
        repeat(n) {
            var win = getCount(it + 1, winLink, n)
            var lose = getCount(it + 1, loseLink, n)
            if(win + lose == n - 1 ) answer++
        }
        
        return answer
    }
}

fun getCount(start: Int, link: Array<BooleanArray>,n: Int): Int {
    var visited = BooleanArray(n + 1) { false }
    var count = 0
    var queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true
    
    while(queue.size != 0) {
        var now = queue.poll()
        
        link[now].forEachIndexed { index, it ->
            if(!visited[index] && it) {
                queue.add(index)
                visited[index] = true
                count++
            }
        }
    }
    
    return count
} 
