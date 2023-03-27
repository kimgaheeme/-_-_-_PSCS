import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> a = new ArrayList<Integer>();
        int count = 0;
        
        for(int i : arr) {
            if(count == 0) {
                a.add(i);
                count++;
            }else if(a.get(count - 1) != i) {
                a.add(i);
                count++;
            }
        }

    
        return a.stream().mapToInt(Integer::intValue).toArray();
    }
}