class Solution {
    fun solution(gems: Array<String>): IntArray {
        
        //맨 앞에 위치하는 값
        var first = 0
        var count = 0
        
        //제일 작은 길이 값
        var start: Int = 0
        var end: Int = 0
        var len = gems.size + 1
        
        //queue에 담겨진 각각 숫자
        var numCount1 = gems.toSet()
        var numCount = mutableMapOf<String, Int>()
        
        if(numCount.size == gems.size) return intArrayOf(1, gems.size)
        
        numCount1.forEach {
            numCount[it] = 0
        }
       
        var i = 0
        
        while(i < gems.size) {
            //만약 이 값이 처음이라면 count를 늘린다.
            if(numCount[gems[i]]!! == 0) count++
            numCount.put(gems[i],numCount[gems[i]]!!+1)
            
            //첫번째 값이 it과 같고 queue에 2개 이상이 들어있으면 뺀다.
            while(numCount[gems[first]]!! > 1) {
                numCount.put(gems[first],numCount[gems[first]]!!-1)
                first++
            }
            
            i++
            if(count == numCount.size && i - first < len ) {
                len = i - first
                start = first
                end = i
            }
        }
        
        return intArrayOf(start+1, end)
    }
}