class Solution {
    
    var answerList = mutableListOf<Array<String>>()
    lateinit var used: BooleanArray
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        used = BooleanArray(tickets.size) { false }
        
        var m = mutableMapOf<String, MutableList<Int>>()
        
        tickets.sortBy{it[1]}
        tickets.forEachIndexed { index, it ->
            var list = m.getOrDefault(it[0], mutableListOf<Int>())
            list.add(index)
            m.put(it[0], list)
        }
        
        dfs(arrayOf<String>("ICN"), m, tickets.size + 1, "ICN", tickets)
        
        
        return answerList[0]
    }
    
    fun dfs(select: Array<String>, ticket: MutableMap<String, MutableList<Int>>, size: Int, now: String, tickets: Array<Array<String>>) {
        
        
        if(select.size == size) {
            answerList.add(select)
            return 
        }
        
        else {
            ticket.getOrDefault(now, mutableListOf<Int>()).forEach {
                if(!used[it]) {
                    used[it] = true
                    dfs(select + tickets[it][1],ticket, size, tickets[it][1], tickets)
                    used[it] = false
                }
            }
        }
    }
}