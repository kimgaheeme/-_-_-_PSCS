import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> list = new Stack<>();
        list.push(0);

        int i = 1;

        for(i = 1; i < prices.length; i++) {
            while(!list.isEmpty() && prices[list.peek()] > prices[i]){
                    answer[list.peek()] = i - list.peek();
                    list.pop();
            }
            list.push(i);
        }

        while(!list.isEmpty()){
            answer[list.peek()] = i - list.peek() - 1;
            list.pop();
        }

        return answer;
    }
}