import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, Collections.reverseOrder());
        
        HashSet<String> set = new HashSet<String>();
        
        for(String s: phone_book) {
            if(set.contains(s)) return false;
            else {
                for(int i = 1; i <= s.length(); i++) {
                    set.add(s.substring(0, i));
                }
            }
        }
        
        
        
        return true;
    }
}