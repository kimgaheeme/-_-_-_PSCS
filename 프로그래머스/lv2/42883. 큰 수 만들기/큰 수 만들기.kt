import kotlin.math.*
import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var list = mutableListOf<Int>()
        var stack = Stack<Int>()
        number.forEach { list.add(it.toString().toInt()) }

        
        var count = 0
        for(index in 0 until list.size){ 
            if(stack.isEmpty()) stack.add(list[index])
            else {
                while(stack.peek() < list[index]) {
                    stack.pop()
                    count++
                    if(count == k) break
                    if(stack.isEmpty()) break
                }
                if(count == k) {
                    for(i in index until list.size) {
                        stack.add(list[i])
                    }
                    break
                }
                else stack.add(list[index])
            }
        }
        
        while(!stack.isEmpty()) {
            answer = stack.peek().toString() + answer
            stack.pop()
        }
        
        return answer.substring(0, number.length - k)
    }
}