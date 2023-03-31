import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf(0, 0)
        var map = mutableMapOf<Int, Int>()
        var minHeap = PriorityQueue<Int>()
        var maxHeap = PriorityQueue<Int>(Comparator{ a, b -> if( a < b) 1 else -1 })
        var size = 0

        operations.forEach { it ->
            var list = it.split(" ")
            
            when(list[0]) {
                "I" -> {
                    map.put(list[1].toInt(), map.getOrDefault(list[1].toInt(), 0) + 1)
                    minHeap.add(list[1].toInt())
                    maxHeap.add(list[1].toInt())
                    size++
                }
                
                "D" -> {
                    if(list[1] == "1" && size != 0) {
                        while(map[maxHeap.peek()]!! == 0) { maxHeap.poll() }
                        map.put(maxHeap.peek(), map[maxHeap.peek()]!! - 1)
                        size--
                    } else if(list[1] == "-1" && size != 0) {
                        while(map[minHeap.peek()]!! == 0) { minHeap.poll() }
                        map.put(minHeap.peek(), map[minHeap.peek()]!! - 1)
                        size--
                    }
                }
            }
        }
        
        if(size == 0) return intArrayOf(0, 0)
        else {
            while(map[maxHeap.peek()]!! == 0) { maxHeap.poll() }
            while(map[minHeap.peek()]!! == 0) { minHeap.poll() }
            return intArrayOf(maxHeap.peek(), minHeap.peek())
        }
        
        return answer
    }
}