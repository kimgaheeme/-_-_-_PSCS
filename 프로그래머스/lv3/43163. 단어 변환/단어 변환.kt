import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        var nwords = words + begin
        var targetAt = -1
        nwords.forEachIndexed {index, it -> if(it == target) targetAt = index}
        if(targetAt == -1) return 0
        

        var link = mutableMapOf<Int, MutableList<Int>>()
        
        for(i in 0 until nwords.size) {
            for(j in i until nwords.size) {
                if(hasConnection(nwords[i], nwords[j])){
                    var listi = link.getOrDefault(i, mutableListOf<Int>())
                    var listj = link.getOrDefault(j, mutableListOf<Int>())
                    listi.add(j)
                    listj.add(i)
                    
                    link.put(i, listi)
                    link.put(j, listj)
                }
            }
        }
        
        var visited = BooleanArray( nwords.size ){ false }
        var queue = LinkedList<Point>()
        queue.add(Point(nwords.size - 1, 0))
        visited[nwords.size - 1] = true
        
        while(queue.size != 0) {
            var now = queue.poll()
            var count = now.count + 1
            
            link.getOrDefault(now.s, mutableListOf<Int>()).forEach {
                if(it == targetAt) return count
                if(!visited[it]) {
                    queue.add(Point(it, count))
                    visited[it] = true
                }
            }
        }
        
        
        return 0
    }
    
    
    fun hasConnection(s1: String, s2: String): Boolean {
        var count = 0
        repeat(s1.length) {
            if(s1[it] != s2[it]) count++
        }
        
        return count == 1
    }
}

data class Point (
    var s: Int,
    var count: Int
)