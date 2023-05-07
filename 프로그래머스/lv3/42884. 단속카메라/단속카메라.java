import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int count = 0;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int min = routes[0][1];
        
        for(int i = 0; i < routes.length; i++) {
            if(routes[i][0] <= min) {
                if(routes[i][1] < min) {
                    min = routes[i][1];
                }
            }
            else {
                answer++;
                min = routes[i][1];
            }
        }
        
        return answer + 1;
    }
}