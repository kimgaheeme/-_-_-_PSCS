import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var count = 0
        var pq = PriorityQueue<IntArray>(Comparator{ a, b -> 
            if(a[1] > b[1]) 1
            else if(a[1] < b[1]) -1
            else a[0] - b[0]
        })
        
        jobs.sortWith(Comparator{ a, b -> 
            if(a[0] > b[0]) 1
            else if(a[0] < b[0]) -1
            else a[1] - b[1]
        })
        
        var time = 0
        var now = 0
        while(count != jobs.size) {
            
            for(i in now until jobs.size) {
                if(jobs[i][0] <= time){
                    pq.add(jobs[i])
                    now++
                }
            }
            
            if(pq.size == 0) {
                pq.add(jobs[now])
                time = jobs[now][0]
                now++
            }
            
            time += pq.peek()[1]
            answer += (time - pq.peek()[0])
            count++
            pq.poll()
        }
        
        return answer / jobs.size
    }
}