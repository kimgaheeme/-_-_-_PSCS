class Solution {
    
    var answer = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        
        
        dfs(0, 0, target, numbers)
        return answer
    }
    
    fun dfs(selected: Int, numNum: Int, target: Int, numbers: IntArray) {
        
        if(selected == numbers.size) {
            if(target == numNum) answer++
            return 
        } 
        
        dfs(selected + 1, numNum + numbers[selected], target, numbers)
        dfs(selected + 1, numNum - numbers[selected], target, numbers)
    }
}

