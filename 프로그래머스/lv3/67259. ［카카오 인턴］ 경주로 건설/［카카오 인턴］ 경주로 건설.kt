import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

class Solution {
    
    private val goX = intArrayOf(0, 0, 1, -1) //우, 좌, 하, 상
    private val goY = intArrayOf(1, -1, 0, 0)
    private var answer = Int.MAX_VALUE
    private lateinit var vis: Array<BooleanArray>
    private lateinit var priceArr: Array<Array<IntArray>>
    
    fun solution(board: Array<IntArray>): Int {
    
        vis = Array(board.size) { BooleanArray(board.size) }
        // 방향, x,y
        priceArr = Array(4){Array(board.size) { IntArray(board.size) { Int.MAX_VALUE } }}
        bfs(board)
        for (i in 0 until 4){
            answer = min(answer, priceArr[i][board.lastIndex][board.lastIndex])
        }
        println(answer)
        return answer
    }
    
    private fun bfs(board: Array<IntArray>) {
        val n = board.size
        val queue: Queue<Road> = LinkedList()
        queue.add(Road(0, 0, 0, -1))
        vis[0][0] = true
        while (queue.isNotEmpty()) {
            val road = queue.poll()
            val (x, y, price, dir) = road

            for (i in 0 until 4) {
                var (nx, ny, nPrice, nDir) = intArrayOf(x + goX[i], y + goY[i], price, i)
                if (nx !in 0 until n || ny !in 0 until n) continue
                if (board[nx][ny]==1) continue
                if (dir == -1) nPrice += 100
                else if (dir != nDir) nPrice += 600
                else nPrice += 100

                if (!vis[nx][ny] || priceArr[nDir][nx][ny] >= nPrice) {
                    vis[nx][ny] = true
                    priceArr[nDir][nx][ny] = nPrice
                    queue.add(Road(nx, ny, nPrice, nDir))
                }
            }
        }
    }
}


data class Road(val x: Int, val y: Int, val price: Int, val dir: Int)


