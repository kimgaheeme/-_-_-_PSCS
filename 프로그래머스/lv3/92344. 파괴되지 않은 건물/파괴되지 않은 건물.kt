class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        var sumBoard = Array(board.size + 1){Array(board[0].size + 1){0}}
        
        
        skill.forEach { 
            var v = if(it[0] == 1) it[5] * (-1) else it[5]
            sumBoard[it[1]][it[2]] += v
            sumBoard[it[3] + 1][it[4] + 1] += v
            sumBoard[it[3] + 1][it[2]] += v * (-1)
            sumBoard[it[1]][it[4] + 1] += v * (-1)
        }
        
        var i = 1
        var j = 1
        
        
        for(i in 0..board.size - 1) {
            for(j in 1..board[0].size - 1){
                sumBoard[i][j] += sumBoard[i][j - 1]
            }
        }
        
        
        
        for(j in 0..board[0].size - 1) {
            for(i in 0..board.size - 1){
                if(i != 0) sumBoard[i][j] += sumBoard[i - 1][j]
                if(sumBoard[i][j] + board[i][j] > 0) answer++
            }
        }
        
        
        
        return answer
    }
}