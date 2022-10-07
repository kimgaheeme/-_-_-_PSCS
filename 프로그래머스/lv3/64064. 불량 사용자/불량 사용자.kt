class Solution {
    
    var answerSet = mutableSetOf<Set<String>>()
    var candidate = ArrayList<ArrayList<String>>()
    
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        
        val begin = System.nanoTime()
		//후보를 찾는다.O(n^2)
		//정규표현식 사용
        banned_id.forEach { it ->
            val e = ArrayList<String>()
            user_id.forEach { u ->
                if(isMatch(it, u)) e.add(u)
            }
            candidate.add(e)
        }
        
        val end = System.nanoTime()
        println(end - begin)
        
        dfs(listOf<String>(), 0)
        val end2 = System.nanoTime()
        println(end2 - end)
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

fun isMatch(star: String, s2: String): Boolean {
    if(star.length != s2.length) return false
    
    star.forEachIndexed { idx, it ->
        if(it != '*' && it != s2[idx] ) return false
    }
    return true
}