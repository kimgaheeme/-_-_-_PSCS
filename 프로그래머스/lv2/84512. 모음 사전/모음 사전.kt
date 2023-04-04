class Solution {
    
    var dict = mutableSetOf<String>()
    
    fun solution(word: String): Int {
        var answer = 0
        var chatList = listOf("A", "E", "I", "O", "U")
        
        dfs("", chatList)
        dict.toList().sorted().forEachIndexed { index, it ->
            if(it == word) return index + 1  
        }
        
        
        return answer
    }
    fun dfs(selected: String, charList: List<String>) {
        if(selected.length != 0) dict.add(selected)
        if(selected.length == 5) return
        
        repeat(5) {
            dfs(selected + charList[it], charList)
        }
        
    }
}