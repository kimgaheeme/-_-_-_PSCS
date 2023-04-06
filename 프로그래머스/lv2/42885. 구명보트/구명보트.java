import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int now = 0;
        int count = 0;
        int end = people.length - 1;
        
        Arrays.sort(people);
        
        boolean[] visited = new boolean[people.length];
        
        for(int i = 0; i < people.length; i++){
            answer++;
            count += 1;
            
            for(int j = end; j > i; j--) {
                if(people[j] + people[i] > limit) {
                    count++;
                    answer++;
                    end = j - 1;
                } else if(people[j] + people[i] <= limit) {
                    count++;
                    end = j - 1;
                    break;
                }
            }
            if(count == people.length) break;
        }
        
        
        return answer;
    }
}