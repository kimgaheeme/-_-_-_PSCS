
lateinit var board: Array<IntArray>
lateinit var dp: Array<IntArray>
fun main() {

    var (y, x) = readln().split(" ").map{ it.toInt()}
    board = Array(y){ readln().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(y) { IntArray(x){ -1 } }

    println(dfs(Pair(0, 0), x, y))
}

fun dfs(now: Pair<Int, Int>, x: Int, y: Int): Int {
    return if(now == Pair(x - 1, y - 1)) 1
    else if(dp[now.second][now.first] != -1) dp[now.second][now.first]
    else {
        dp[now.second][now.first] = 0
        repeat(4) {
            if(now.second + dy[it] in 0 until y && now.first + dx[it] in 0 until x &&
                board[now.second + dy[it]][now.first + dx[it]] < board[now.second][now.first]
            ) {
                dp[now.second][now.first] += dfs(Pair(now.first + dx[it], now.second + dy[it]),x, y)
            }
        }
        dp[now.second][now.first]
    }
}