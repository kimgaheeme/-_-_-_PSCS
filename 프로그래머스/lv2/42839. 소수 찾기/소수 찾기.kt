class Solution {
    
    lateinit var visited: BooleanArray
    var size = 0
    var answerSet = mutableSetOf<Int>()
    
    fun solution(numbers: String): Int {
        var answer = 0
        size = numbers.length
        visited = BooleanArray(size){ false }
        
        dfs("", numbers)
        
        return answerSet.size
    }
    
    fun dfs(number: String, numbers: String) {
        if(number.length != 0 && isPrime(number.toInt())) {
            answerSet.add(number.toInt()) 
        }
        
        repeat(size) {
            if(!visited[it]){
                visited[it] = true
                dfs(number + numbers[it], numbers)
                visited[it] = false
            }
        }
    }
    
    fun isPrime(number: Int): Boolean {

        if(number == 0 || number == 1) return false
            
        repeat(number - 2) {
            if(number % (it + 2) == 0) {
                return false
            }
        }  
        return true
    }
}