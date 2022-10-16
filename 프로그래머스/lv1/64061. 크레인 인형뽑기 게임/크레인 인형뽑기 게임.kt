class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = arrayListOf<Int>()

        moves.forEach {
            for (i in board.indices) {
                if (board[i][it - 1] != 0) {
                    if (stack.isNotEmpty() && stack.last() == board[i][it - 1]) {
                        answer += 2
                        stack.removeAt(stack.lastIndex)
                    } else {
                        stack.add(board[i][it - 1])
                    }
                    board[i][it - 1] = 0

                    break
                }
            }
        }
        return answer
    }
}