import java.util.*
class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf(0, 0)
        var m = mutableMapOf<Int, Int>()
        var count = 0
        
        var pqMin = PriorityQueue<Int>()
        var pqMax = PriorityQueue<Int>(Comparator { a, b -> b - a})
        
        operations.forEach {
            var op = it.split(" ")
            if(op[0] == "I") {
                var num = op[1].toInt()
                var c = m.getOrDefault(num, 0)
                m.put(num, c + 1)
                count++
                pqMin.add(num)
                pqMax.add(num)
            }else if(op[1] == "-1") {
                if(count != 0) {
                    while(m.getOrDefault(pqMin.peek(), 0) == 0) {
                        pqMin.poll()
                    }
                    var newNum = m.getOrDefault(pqMin.peek(), 0) - 1
                    m.put(pqMin.peek(), newNum)
                    pqMin.poll()
                    count--
                }
                
            } else {
                if(count != 0) {
                    while(m.getOrDefault(pqMax.peek(), 0) == 0) {
                        pqMax.poll()
                    }
                    var newNum = m.getOrDefault(pqMax.peek(), 0) - 1
                    m.put(pqMax.peek(), newNum)
                    pqMax.poll()
                    count--
                    
                }
            }
        }
        
        if(count == 0) return answer
        
        while(m.getOrDefault(pqMax.peek(), 0) == 0) {
            pqMax.poll()
        }
        while(m.getOrDefault(pqMin.peek(), 0) == 0) {
            pqMin.poll()
        }
        
        answer[0] = pqMax.peek()
        answer[1] = pqMin.peek()
        
        return answer
    }
}

