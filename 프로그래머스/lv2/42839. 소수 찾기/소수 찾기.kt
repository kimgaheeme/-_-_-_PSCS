class Solution {
    
    var list = mutableSetOf<Int>()
    lateinit var visited: BooleanArray
    
    fun solution(numbers: String): Int {
        var answer = 0
        visited = BooleanArray(numbers.length){ false }
        
        dfs("", numbers.length, numbers)
        
        list.forEach{
            if(isPrime(it)) answer++
        }
        return answer
    }
    
    fun dfs(selected: String, size: Int, numbers: String) {
        if(selected != "") list.add(selected.toInt())

        repeat(size) {
            if(!visited[it]) {
                visited[it] = true
                dfs(selected + numbers[it], size, numbers)
                visited[it] = false
                
            }
        }
    }
    
    fun isPrime(num: Int): Boolean {
        if(num == 0 || num == 1) return false
        else {
            repeat(num - 2) {
                if(num % (it + 2) == 0) return false
            }
        }
        return true
    }
    
    
}