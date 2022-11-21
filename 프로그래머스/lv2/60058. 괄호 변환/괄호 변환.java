import java.util.Stack;
class Solution {
    public String solution(String p) {
        String answer = getRightString(p);
        return answer;
    }
    public String getRightString(String p) {
        //1번
        if(p.isEmpty()) return "";
        //2번
        int start = 0;
        int end = 0;
        String u = "";
        int i;
        for(i = 0 ; i<p.length(); i++) {
            if(p.charAt(i) == '(') start++;
            else end++;
            
            u += p.charAt(i) ;
            if(start == end) break;
        }
        String v = p.substring(i + 1);
        
        //3번
        if(isRight(u)) return u + getRightString(v);
        else return '(' + getRightString(v) + ')' + getReverse(u);
    }
    public Boolean isRight(String p) {
        Stack<Character> left = new Stack<>();
        
        for(int i = 0; i< p.length(); i++) {
            if(left.empty()) left.push(p.charAt(i) );
            else if(left.peek() != p.charAt(i)  && p.charAt(i)  == ')') left.pop();
            else left.push(p.charAt(i) );
        }
        
        if(left.empty()) return true; else return false;
    }
    public String getReverse(String u) {
        String answer = "";
        
        for(int i = 1 ; i < u.length() - 1  ; i++) {
            if(u.charAt(i) == '(') answer += ')';
            else answer += '(';
        }
        
        return answer;
    }
}