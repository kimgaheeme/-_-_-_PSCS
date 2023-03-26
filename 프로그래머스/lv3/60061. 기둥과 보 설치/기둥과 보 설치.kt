lateinit var list: Array<Array<IntArray>>

class Solution {
    
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        list = Array(n + 1) { Array(n + 1 ){ IntArray(4) { 0 } } }
        var answer = arrayOf<IntArray>()
        
        repeat(n + 1) {
            list[it][0][2] = 1
        }
        
        //순회
        build_frame.forEach { frame->
            var x = frame[0]
            var y = frame[1]
            
            if(frame[2] == 0 && frame[3] == 0) {//기둥 삭제
                deleteColumn(x,y)
                if(!canDeleteColumn(x,y)) { addColumn(x,y)}
                
            }
            else if(frame[2] == 0 && frame[3] == 1) {//기둥 추가
                if(canColumn(x,y)) addColumn(x,y)
                
            }
            else if(frame[2] == 1 && frame[3] == 0) {//보 삭제 
                deleteBeam(x, y, x + 1, y)
                if(!canDeleteBeam(x, y, x + 1, y)) addBeam(x, y, x + 1, y)
            }
            else if(frame[2] == 1 && frame[3] == 1) {//보 추가
                if(canBeam(x,y, x + 1, y)) addBeam(x,y, x + 1, y)   
            }
        }
        
        //정답 찾기
        repeat(n + 1) { x ->
            repeat(n + 1) { y ->
                if(list[x][y][0] == 1) answer += intArrayOf(x,y,0)
                if(list[x][y][1] == 1) answer += intArrayOf(x,y,1)
            }
        }
        return answer
    }
    
    //보? ㄱㄴ?(점두개)
    fun canBeam(leftX: Int, leftY: Int, rightX:Int, rightY: Int): Boolean {
        if(list[leftX][leftY][3] == 1 && list[rightX][rightY][1] == 1) return true
        else if(list[leftX][leftY][2] == 1 || list[rightX][rightY][2] == 1) return true
        return false
    }
    
    //기둥? ㄱㄴ? (점 하나)
    fun canColumn(x: Int, y: Int): Boolean {
        repeat(3) { if(list[x][y][it + 1] == 1) return true }
        return false
    }
    
    //add 기둥
    fun addColumn(x: Int, y: Int) {
        list[x][y][0] = 1
        list[x][y + 1][2] = 1
    }
    
    fun addBeam(leftX: Int, leftY: Int, rightX:Int, rightY: Int) {
        list[leftX][leftY][1] = 1
        list[rightX][rightY][3] = 1
    }
    
    //delete 기둥
    fun deleteColumn(x: Int, y: Int) {
        list[x][y][0] = 0
        list[x][y + 1][2] = 0
    }
    
    fun deleteBeam(leftX: Int, leftY: Int, rightX:Int, rightY: Int) {
        list[leftX][leftY][1] = 0
        list[rightX][rightY][3] = 0
    }
    
    //delete 기둥?
    fun canDeleteColumn(x: Int, y: Int): Boolean {
        if(list[x][y+1][0] == 1 && !canColumn(x, y+1)) return false
        else if(list[x][y+1][1] == 1 && !canBeam(x, y+1, x+1, y+1)) return false
        else if(list[x][y+1][3] == 1 && !canBeam(x-1, y+1, x, y+1)) return false
        else return true
    }
    
    fun canDeleteBeam(leftX: Int, leftY: Int, rightX:Int, rightY: Int): Boolean {
        if(list[leftX][leftY][0] == 1 && !canColumn(leftX, leftY)) return false
        else if(list[rightX][rightY][0] == 1 && !canColumn(rightX, rightY)) return false
        else if(list[leftX][leftY][3] == 1 && !canBeam(leftX - 1, leftY, leftX, leftY)) return false
        else if(list[rightX][rightY][1] == 1 && !canBeam(rightX, rightY, rightX + 1, rightY)) return false
        return true
        
    }

}

