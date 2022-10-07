class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        
				//candidate : 각각의 banned_id가 될 수 있는 값들의 후보
        var candidate = ArrayList<ArrayList<String>>()
				
				//후보를 찾는다.O(n^2) 
        banned_id.forEach { it ->
            val r = it.replace("*",".").toRegex()
            val e = ArrayList<String>()
            user_id.forEach { u ->
                if(u.matches(r)) e.add(u)
            }
            candidate.add(e)
        }

				//answerSet = 정답으로 이루어진 Set
        var answerSet = mutableSetOf<Set<String>>()

				//첫번째의 경우는 그냥 넣어준다.
        candidate[0].forEach { o -> answerSet.add(setOf(o)) }
        

		//합집합을 만들어서 정답Set을 만들어준다.
		//O(N^2)??
        repeat(candidate.size - 1) { idx ->
            var answerSet1 = answerSet
                    .flatMap { o ->
                        candidate[idx + 1].map {c -> 
                            o.union(setOf(c))
                        }
                    }.filter{it.size == idx + 2}.toMutableSet()
            answerSet = answerSet1
        }
        
				//만약 크기가 bannedId와 같지않다면 정답이 될 수 없다.
        answerSet.forEach {
            if(it.size == candidate.size) answer++
        }

        return answer
    }
}