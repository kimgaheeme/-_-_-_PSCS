class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""
         
        //1단계
        answer = new_id.lowercase()
        
        var answer2 = ""
        //2단계
       answer.toList().forEach {
            if(it.isLetterOrDigit() || it == '-' || it == '_' || it == '.') answer2 += it
        }
        //3단계
        while(answer2.indexOf("..") != -1) {
            answer2 = answer2.replace("..",".")
        }
        //4단계
        if(!answer2.isEmpty()) {
            if(answer2[0] == '.') answer2 = answer2.substring(1)
        }
        if(!answer2.isEmpty()) {
            if(answer2[answer2.length - 1] == '.') answer2 = answer2.substring(0 until answer2.length -1)
        }
        //5단계
        if(answer2.isEmpty()) answer2 = "a"
        //6단계
        if(answer2.length >= 16) answer2 = answer2.substring(0 until 15)
        if(!answer2.isEmpty()) {
            if(answer2[answer2.length - 1] == '.') answer2 = answer2.substring(0 until answer2.length -1)
        }
        //7단계
        if(answer2.length < 3) {
            while(answer2.length != 3) {
                answer2 += answer2[answer2.length - 1]
            }
        }
        
        println(answer2)
        return answer2
    }
}