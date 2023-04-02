import java.util.*;

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        var word = mutableListOf(begin)
        word.addAll(words.toList())
        
        var targetPoint = 0
        word.forEachIndexed{ index,it ->if(it == target) targetPoint = index }
        if(targetPoint == 0) return 0
        
        var visited = BooleanArray(word.size){ false }
        visited[0] = true
        
        var connectList = Array(word.size){BooleanArray(word.size){ false }}
        
        word.forEachIndexed { start, startString ->
            word.forEachIndexed { end, endString ->
                if(canChange(startString, endString)) {
                    connectList[start][end] = true
                    connectList[end][start] = true
                }
            }
        }
        
        var queue = LinkedList<Pair<Int, Int>>()
        
        queue.add(Pair(0, 0))
        
        while(queue.isNotEmpty()) {
            var now = queue[0].first
            var count = queue[0].second + 1
            queue.removeFirst()
            
            repeat(word.size) {
                if(!visited[it] && connectList[now][it]) {
                    if(it == targetPoint) return count
                    visited[it] = true
                    queue.add(Pair(it, count))
                }
            }
        }
        
        return 0
    }
    
    fun canChange(s1: String, s2: String): Boolean {
        var count = 0
        repeat(s1.length) {
            if(s1[it] != s2[it]) count++
        }
        
        return count == 1
    }
}