val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)
var dp = arrayOf<IntArray>()
var route = arrayOf<IntArray>()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }

    route = Array(m) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    dp = Array(m) {
        IntArray(n) { -1 }
    }

    println(dfs(m, n, 0, 0))
}

fun dfs(m: Int, n: Int, y: Int, x: Int): Int {
    if (y == m - 1 && x == n - 1) {
        return 1
    }

    if (dp[y][x] != -1) {
        return dp[y][x]
    }

    dp[y][x] = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m) continue
        if (route[y][x] > route[ny][nx]) {
            dp[y][x] += dfs(m, n, ny, nx)
        }
    }

    return dp[y][x]
}