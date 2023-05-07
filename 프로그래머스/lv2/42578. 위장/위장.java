import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        
        for(String[] it : clothes) {
            m.put(it[1], m.getOrDefault(it[1], 0) + 1);
        }
        
        for(int it : m.values()) {
            answer *= (it + 1);
        }
        
        return answer - 1;
    }
}