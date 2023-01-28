const val yearToDay = 336
const val monthToDay = 28

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        
        var answer: IntArray = intArrayOf()
        var todayValue = toDay(today)
        var termMap = mutableMapOf<String, Int>()
        
        terms.forEach {
            termMap.put(it.split(" ")[0], it.split(" ")[1].toInt() * monthToDay)
        }
        
        //privacies -> 공백으로 split, 앞에꺼 변환 + map, 그 값이 today 보다 같거나 작으면X
        privacies.forEachIndexed { index, it ->
            if(toDay(it.split(" ")[0]) + termMap[it.split(" ")[1]]!! <= todayValue){
                answer = answer.plus(index + 1)
            }
        }
        
    
        return answer
    }
}

fun toDay(date: String): Int {
    var arr = date.split(".")
    var result = arr[2].toInt()
    
    result += ((arr[0].toInt() - 2000) * yearToDay)
    result += (arr[1].toInt() * monthToDay)
    
    return result
}