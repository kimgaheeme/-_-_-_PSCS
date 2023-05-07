import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var count = 0
        var stack = Stack<Char>()
        
        number.forEach{ 
            if(stack.isEmpty()) stack.add(it)
            else if(count < k) {
                while(stack.peek() < it && !stack.isEmpty()) {
                    stack.pop()
                    count++
                    if(count == k || stack.isEmpty()) break;
                }
                stack.add(it)
            }else {
                stack.add(it)
            }
        }
        
        while(!stack.isEmpty()) {
            answer = stack.peek() + answer
            stack.pop()
        }
        
        return answer.substring(0, number.length - k)
    }
}