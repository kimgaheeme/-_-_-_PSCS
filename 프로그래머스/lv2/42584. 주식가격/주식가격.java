import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Price> list = new Stack<>();
        
        list.push(new Price(prices[0], 0));
        
        int i = 1;
        
        for(i = 1; i < prices.length; i++) {
            if(list.isEmpty() || list.peek().p <= prices[i]){
                list.push(new Price(prices[i], i));
            } else {
                while(!list.isEmpty() && list.peek().p > prices[i]){
                    answer[list.peek().point] = i - list.peek().point;
                    list.pop();
                }
                list.push(new Price(prices[i], i));
            }
        }
        
        while(!list.isEmpty()){
            answer[list.peek().point] = i - list.peek().point - 1;
            list.pop();
        }
        
        return answer;
    }
}

class Price{
    int p;
    int point;
    
    Price(int p, int  point) { 
        this.p = p;
        this.point = point;
    }
    
    public int getP(){ return this.p; }
    
    public int getPoint(){ return this.point; }
}