import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        LinkedList<String> cache = new LinkedList<String>();
        int answer = 0;
        
        for(String c: cities) {
            
            String city = c.toUpperCase();
            
            if(cacheSize == 0) answer += 5;
            else if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
            } else if(cache.size() >= cacheSize) {
                cache.removeFirst();
                cache.add(city);
                answer += 5;
            } else {
                cache.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}