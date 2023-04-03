class Solution {
    
    var answer = arrayOf<Array<String>>()
    var ticketSize = 0
    lateinit var visited: BooleanArray
    lateinit var ticketArray: Array<Array<String>>
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        
        ticketArray = tickets
        ticketSize = tickets.size
        visited = BooleanArray(ticketSize){ false }
        
        //map으로 연결되어있는지 표시
        var ticket = mutableMapOf<String, MutableList<Int>>()
        tickets.forEachIndexed { index, it ->
            var list = ticket.getOrDefault(it[0], mutableListOf<Int>())
            list.add(index)
            ticket.put(it[0], list)
        }
        
        //count로 dfs
        dfs(arrayOf<String>("ICN"), "ICN", ticket)
    
        return getAnswer()
    }
    fun dfs(selected: Array<String>, now: String, ticket: MutableMap<String, MutableList<Int>>) {
        //만약 selected가 tickets개수와 같다면 return
        if(selected.size == ticketSize + 1) {
            answer += selected 
        }else{
            //now에서 출발할 수 있는 비행권 순회 하는데 ticket에서 빼기
            var list = ticket.getOrDefault(now, mutableListOf<Int>())
            
            list.forEach{  it ->
                if(!visited[it]) {
                    visited[it] = true
                    var dest = ticketArray[it][1]
                    dfs(selected + dest, dest, ticket)
                    visited[it] = false
                }
            }
        }
        
    }
    
    fun getAnswer(): Array<String> {
        var list = answer.map{
            it.reduce(){
                total, s -> total + s
            }
        }.sorted()[0]
        
        var answer = arrayOf<String>()
        
        repeat(ticketSize + 1) {
            answer += list.substring(it * 3, it * 3 + 3)
        }
        return answer
    }
}