class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(p + m * t > sb.length()) {
            sb.append(Integer.toString(i, n));
            i++;
        }
        String str = sb.toString().toUpperCase();
            
        
        int j = 0;
        while(j < t) {
            answer += str.charAt(p - 1 + j * m);
            j++;
        }
        return answer;
    }
}