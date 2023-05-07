import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        ArrayList<Integer> answerList = new ArrayList<>();
        
        //한 단어 넣기
        for(char i = 'A'; i <= 'Z'; i++) {
            dict.put(Character.toString(i), i - 'A' + 1);
        }
        
        int i = 0;
        while(i < msg.length()) {
            int j = 1;
            
            while(i + j - 1 < msg.length()) {
                if(!dict.containsKey(msg.substring(i, i + j))) {
                    answerList.add(dict.get(msg.substring(i, i + j - 1)));
                    dict.put(msg.substring(i, i + j), dict.size() + 1);         
                    break;
                }
                j++;
            } 
            
            if(i + j - 1 == msg.length()) {
                answerList.add(dict.get(msg.substring(i, i + j - 1)));
                break;
            }
            
            i += (j - 1);
            
        }
        
        int[] answer = new int[answerList.size()];
        
        for(i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}