class Solution {
    
    var dict = mutableListOf<String>()
    
    fun solution(word: String): Int {
        var answer = 0
        var c = listOf('A', 'E', 'I', 'O', 'U')
        
        dfs("", c)
        
        dict.forEachIndexed { index, it ->
            if(it == word) return index + 1
        }
        return answer
    }
    
    fun dfs(selected: String, c: List<Char>) {
        if(selected != "") dict.add(selected)
        if(selected.length == 5) return
        repeat(5) {
            dfs(selected + c[it], c)
        }
    }
    
    
}