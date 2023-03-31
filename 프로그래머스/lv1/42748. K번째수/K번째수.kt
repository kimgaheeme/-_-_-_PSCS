class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        
        var list = array.toList()
        
        commands.forEach{
            answer += list.subList(it[0] - 1, it[1]).sorted()[it[2] - 1]
        }
        
        return answer
    }
}