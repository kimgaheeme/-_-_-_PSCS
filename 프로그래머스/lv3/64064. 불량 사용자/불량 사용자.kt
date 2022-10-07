class Solution {
    
    var answerSet = mutableSetOf<Set<String>>()
    var candidate = ArrayList<ArrayList<String>>()
    
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {		
		//후보를 찾는다.O(n^2)
		//정규표현식 사용
        banned_id.forEach { it ->
            val r = it.replace("*",".").toRegex()
            val e = ArrayList<String>()
            user_id.forEach { u ->
                if(u.matches(r)) e.add(u)
            }
            candidate.add(e)
        }
        
        dfs(listOf<String>(), 0)
        
        return answerSet.size
    }
    
    fun dfs(currentList: List<String>, depth: Int) {
    
    if(depth == candidate.size) {
        answerSet.add(currentList.toSet())
        return
    }
    
    candidate[depth].forEach { 
        if(!currentList.contains(it)) dfs(currentList + it, depth+1)
    }
}
}

