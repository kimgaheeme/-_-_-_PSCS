var scoreArray = arrayListOf<Int>()
class Solution {
    fun solution(info: Array<String>, query: Array<String>): ArrayList<Int> {
        var answer = arrayListOf<Int>()
        var infos = arrayListOf<List<String>>()
        var m = mutableMapOf<Set<String>, MutableList<Int>>()
        var m2 = mutableMapOf<Set<String>, List<Int>>()
        //var scoreArray = arrayListOf<Int>()
    
        
        info.forEachIndexed { index, it ->
            var arr = it.split(" ")
            var k = arr.subList(0, 4).toSet()
            if(m.containsKey(k)) m[k]!!.add(arr[4].toInt())
            else m.put(k, mutableListOf(arr[4].toInt()))
        }
        
        
        m.forEach { (key, value) ->
            m2.put(key, value.sorted())
        }
        
        query.forEachIndexed { index, it ->
            var arr = it.split(" ")
            var queryKey = arr.filterIndexed { index, it -> index % 2 == 0 && it != "-"}.toSet()
            var s = mutableListOf<Int>()
            var count = 0
            
            if(m2.contains(queryKey)) answer.add(binarySearch(m2[queryKey]!!, arr[7].toInt()))
            else {
                m.forEach { (key, value) ->
                    if(key.containsAll(queryKey)) s.addAll(value)
                }
                m2.put(queryKey, s.sorted())
                answer.add(binarySearch(m2[queryKey]!!, arr[7].toInt()))
            }

        }
        
        
        return answer
    }
    
    fun binarySearch(arr: List<Int>, target: Int): Int {
       
        var low = 0
        var high = arr.lastIndex
        var mid = 0;
        var temp = arr.size

        while (low <= high) {
            mid = (low + high) / 2

            when {
                arr[mid] >= target -> {
                    high = mid - 1
                    temp = mid
                }
                else -> low = mid + 1
            }
        }
        return arr.size - temp
    }
    
}