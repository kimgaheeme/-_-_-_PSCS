import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //큐 만들고 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //집어넣기
        for(int i : scoville) { pq.add(i); }
        
        //while peek >= K
        while(pq.peek() < K) {
            if(pq.size() == 1 && pq.peek() < K) return -1;
            
            int v1 = pq.poll();
            int v2 = pq.poll();
            
            pq.add(v1 + v2 * 2);
            answer++;
        }
        
        return answer;
    }
}