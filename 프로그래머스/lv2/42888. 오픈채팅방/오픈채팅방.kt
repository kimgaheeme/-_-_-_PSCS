class Solution {
    fun solution(record: Array<String>): ArrayList<String> {
        var answer = arrayListOf<String>()
        
        //나갔다 들어온 기록
        //in = true out = false
        var inoutrecode = arrayListOf<Pair<String, Boolean>>()
        //key = id value = nickname
        val nickname = mutableMapOf<String,String>()
        
        record.forEach {
            when(it[0]) {
                'E' -> {
                    var id = it.split(" ")[1]
                    var n = it.split(" ")[2]
                    inoutrecode.add(Pair(id, true))
                    nickname.put(id, n)
                }
                'L' -> {
                    var id = it.split(" ")[1]
                    inoutrecode.add(Pair(id, false))
                }
                'C' -> {
                    var id = it.split(" ")[1]
                    var n = it.split(" ")[2]
                    nickname.put(id, n)
                }
            }
        }
        
        inoutrecode.forEach {
            if(it.second) answer.add("${nickname[it.first]}님이 들어왔습니다.")
            else answer.add("${nickname[it.first]}님이 나갔습니다.")
        }
        
        return answer
    }
}