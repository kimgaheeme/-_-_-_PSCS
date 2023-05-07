import java.util.*

var now = Fish(0, 0, 0)
var smallFish = 2
var eat = 0
lateinit var fishes: Array<IntArray>


fun main() {
    var N = readLine()!!.toInt()
    fishes = Array(N) { IntArray(N){0} }

    repeat(N){ y ->
        readLine()!!.split(" ").forEachIndexed{ x, num ->
            fishes[y][x] = num.toInt()
            if(fishes[y][x] == 9) {
                now.x = x
                now.y = y
                fishes[y][x] = 0
            }
        }
    }

    var count = 0

    while(true) {
        var c = findWay(N)
        
        if(c > 0) {
            count += c
            if(smallFish == eat) {
                eat = 0
                smallFish++
            }
        }
        else {
            println(count)
            return
        }
    }
}

fun findWay(N: Int): Int {
    var dx = listOf(0, 1, 0, -1)
    var dy = listOf(-1, 0, 1, 0)

    //BFS로 거리만큼 갈 수 있는 친구들을 찾는다.
    var queue = LinkedList<Fish>()
    queue.add(Fish(now.x, now.y, 0))
    var visited = Array(N){BooleanArray(N) { false } }
    visited[now.y][now.x] = true

    while(queue.size != 0) {
        var n = queue.poll()
        
        if(fishes[n.y][n.x] != 0 && fishes[n.y][n.x] != smallFish) {
            while(queue.size != 0) {
                var n2 = queue.poll()
                if(n2.len == n.len){
                    if((n.y > n2.y) || (n.y == n2.y && n.x > n2.x)) {
                        if(fishes[n2.y][n2.x] != 0 && fishes[n2.y][n2.x] != smallFish) n = n2
                    }
                }else break
            }
            fishes[n.y][n.x] = 0
            now = n
            eat++
            return n.len
        }

        repeat(4) {
            var x = n.x + dx[it]
            var y = n.y + dy[it]
            if(x in 0 until N &&
                 y in 0 until N &&
                    fishes[y][x] <= smallFish &&
                    !visited[y][x]) {
                visited[y][x] = true
                queue.add(Fish(x, y, n.len + 1))
            }
        }
    }

    return 0
}

data class Fish(
    var x: Int,
    var y: Int,
    var len: Int
)