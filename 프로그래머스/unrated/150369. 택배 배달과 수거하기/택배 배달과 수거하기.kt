import java.util.Stack

class Solution {
        fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0

        var pStack = Stack<Int>()
        var dStack = Stack<Int>()

        deliveries.forEachIndexed{ idx, it ->
            repeat(it){
                dStack.push(idx)
            }
        }

        pickups.forEachIndexed{ idx, it ->
            repeat(it){
                pStack.push(idx)
            }
        }

        while(pStack.isNotEmpty() || dStack.isNotEmpty()) {
            if(pStack.isEmpty()) {
                answer += dStack.peek() + 1
                if(dStack.size <= cap) break;
                else {
                    repeat(cap){
                        dStack.pop()
                    }
                }
            }
            else if(dStack.isEmpty()) {
                answer += pStack.peek() + 1
                if(pStack.size <= cap) break;
                else {
                    repeat(cap){
                        pStack.pop()
                    }
                }
            } else {
                if(pStack.peek() > dStack.peek()) answer += pStack.peek() + 1
                else answer += dStack.peek() + 1

                repeat(cap) {
                    if(pStack.isNotEmpty()) pStack.pop()
                    if(dStack.isNotEmpty()) dStack.pop()
                }
            }
        }

        return answer * 2
    }
}