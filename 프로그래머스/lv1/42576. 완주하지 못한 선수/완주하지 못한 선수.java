import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        HashMap<String, Integer> people = new HashMap<String, Integer>();
        
        Arrays.stream(participant)
            .forEach(p -> {people.put(p, people.containsKey(p) ? people.get(p) + 1 : 1);});
        
        Arrays.stream(completion)
            .forEach(p -> {if(people.get(p).equals(1)) people.remove(p); else people.put(p, people.get(p) - 1);});
        
        for(String s : people.keySet()) answer = s;
        
        return answer;
    }
}