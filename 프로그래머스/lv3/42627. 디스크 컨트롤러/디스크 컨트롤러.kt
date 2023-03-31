import java.util.*;

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        
        var time = 0
        var done = 0
        var front = 0
        var answer = 0
        
        var job = jobs.toList().sortedWith(compareBy({it[0]}, {it[1]}))
        
        var pq = PriorityQueue(Comparator<Pair<Int, Int>>{ p1, p2 ->
            if(p1.second > p2.second) 1 else -1
        })
        
        while(done != job.size) {
            while(front < job.size && job[front][0] <= time ) {
                pq.add(Pair(job[front][0], job[front][1]))
                front++
            }
            
            if(pq.peek() == null) {
                pq.add(Pair(job[front][0], job[front][1]))
                front++
                time = pq.peek().first
            }
            
            var j = pq.poll()
            time += j.second
            answer += (time - j.first)
            done++
        }
        
        
        return answer / job.size
    }
}