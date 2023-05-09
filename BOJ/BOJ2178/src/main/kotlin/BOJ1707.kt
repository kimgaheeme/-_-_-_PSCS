import java.util.*

fun main() {
    var K = readln().toInt()

    repeat(K) {
        if(isPossible()) println("YES") else println("NO")
    }
}

fun isPossible(): Boolean {
    var (V, E) = readln().split(" ").map { it.toInt() }
    var numsLocation = IntArray(V + 1) { 0 }
    var link = Array(V + 1) { mutableListOf<Int>() }

    repeat(E) {
        var nums = readln().split(" ").map { it.toInt() }
        link[nums[0]].add(nums[1])
        link[nums[1]].add(nums[0])
    }

    var visited = BooleanArray(V + 1) { false }
    visited[1] = true
    var visitedCount = 0
    var queue = LinkedList<Int>()

    queue.add(1)
    numsLocation[1] = 1

    while(visitedCount != V) {
        var now = queue.poll()
        visitedCount++

        link[now].forEach {
            if(numsLocation[it] == numsLocation[now]) return false
            else numsLocation[it] = numsLocation[now] * -1

            if(!visited[it]) {
                queue.add(it)
                visited[it] = true
            }
        }


        if(queue.isEmpty()) {
            for(i in 1 .. V) {
                if(!visited[i]) {
                    queue.add(i)
                    numsLocation[i] = 1
                    visited[i] = true
                    break
                }
            }
        }
    }

    return true
}