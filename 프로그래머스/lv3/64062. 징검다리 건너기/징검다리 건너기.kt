class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = stones.maxOrNull()!!
        val len = stones.size
        
        var Des = 0
        var j = 1
        while (j < stones.size) {
            if(stones[j] < stones[j - 1]) Des++
            j++
        }
        
        var stone = stones.toList()
        if(Des > (stones.size - Des - 1)) stone = stone.asReversed()
        
        //현재 위치
        var now = -1
        //위치가 len보다 작을 때 수행
        while (now < len) {
            //구간의 최대값
            var tempValue = 0
            
            //마지막 인덱스 
            var tempIndex = if (now + k < len) now + k else len - 1
            
            //구간 탐색
            for (i in now+1..now+k) {
                
                //만약 범위 오버(끝부분) 끝
                if (i >= len) return answer
                
                //현재 stone이 값이 더 크면
                if (tempValue < stone[i]) {
                    //교체한다.
                    tempValue = stone[i]
                    //최대값의 위치
                    tempIndex = i
                    if (answer <= stone[i]) break
                }
            }
            //최대값이 최소값이면 변경
            if (answer >= tempValue) answer = tempValue
            now = tempIndex
        }
        return answer
    }
}
