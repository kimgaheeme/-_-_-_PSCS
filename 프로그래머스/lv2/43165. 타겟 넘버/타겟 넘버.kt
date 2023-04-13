class Solution {
    
    var count = 0
    
    fun solution(numbers: IntArray, target: Int): Int {        
        dfs(0, 0, target, numbers)
        return count
    }
    
    fun dfs(depth: Int, selected: Int, target: Int, numbers: IntArray) {
        if(depth == numbers.size) {
            if(selected == target) count++
            return
        }
        
        dfs(depth + 1, selected + numbers[depth], target, numbers)
        dfs(depth + 1, selected - numbers[depth], target, numbers)
    }
}