import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        HashMap<String, Integer> people = new HashMap<String, Integer>();
        
        for(String p : participant) people.put(p, people.containsKey(p) ? people.get(p) + 1 : 1);
        for(String p : completion) {
            if(people.get(p).equals(1)) people.remove(p); 
            else people.put(p, people.get(p) - 1);
        }
        
        for(String s : people.keySet()) answer = s;
        
        return answer;
    }
}