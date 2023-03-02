import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Integer> poketmon = new HashMap<>();
        int i = 0;
        int len = nums.length;
        
        //각 포켓몬의 개수를 구한다.
        for(i = 0; i < len; i++) {
            poketmon.put(nums[i], poketmon.containsKey(nums[i]) ? (poketmon.get(nums[i]) + 1) : 1);
        }
        
        //만약 포켓몬 종류 >= N/2 이면 정답은 N/2 
        //그렇지 않으면 포켓몬 종류이다.
        if(poketmon.size() >= len / 2) return len / 2;
        else return poketmon.size();
    }
}