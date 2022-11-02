class Solution {
    fun solution(orders: Array<String>, course: IntArray): List<String> {
        var answer: ArrayList<String> = arrayListOf<String>()
        var answerMap = mutableMapOf<Set<Char>, Int>()
        
        orders.forEach { order ->
            var answer2 = mutableListOf<List<Char>>()
            var arr = order.toList()
            course.forEach { size ->
                combination(answer2, arr, Array<Boolean>(arr.size) { false }, 0,  size)
            }
            answer2.forEach {
                var se = it.toSet()
                if(!answerMap.containsKey(se)) {answerMap.put(se, 1)}
                else {answerMap.put(se, answerMap[se]!! + 1)}
            }
        }
        
        course.forEach { size ->
            var max = 0
            answerMap.forEach {
                if(it.key.size == size && it.value > max) max = it.value
            }
            if(max > 1) {
                var a = answerMap.forEach {
                var s = ""
                if(it.key.size == size && it.value == max) {
                    it.key.sorted().forEach {
                        s = s + it
                    }
                    answer.add(s)
                }
                
            }
            }
        }
        
        return answer.sorted()
    }
}

fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
    if(target == 0) {
        answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
    } else {
        for(i in start until el.size) {
            ck[i] = true
            combination(answer, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}