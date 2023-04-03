import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        boolean[][] visited = new boolean[51][51];
        LinkedList<Point> queue = new LinkedList<>();
        
        queue.add(new Point(characterX, characterY, 0));
        visited[characterX][characterY] = true;
        
        
        while(queue.size() != 0) {
            Point now = queue.get(0);
            queue.removeFirst();
            if(now.x == itemX && now.y == itemY) return now.count;
            
            for(int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x >= 0 && x <= 50 && y >= 0 && y <= 50) {
                    if(isOutLine(now.x, now.y, x, y, rectangle) && !visited[x][y]){
                        queue.add(new Point(x, y, now.count + 1));
                        visited[x][y] = true;
                    }   
                }
            }
            
        }
        return 0;
    }
    
    public boolean isOutLine(int startX, int startY, int endX, int endY, int[][] rectangle) {

        boolean isIn = false;
        
        for(int i = 0; i < rectangle.length; i++) {
            if(startX >= rectangle[i][0] && startX <= rectangle[i][2] 
               && endX >= rectangle[i][0] && endX <= rectangle[i][2] 
               && startY >= rectangle[i][1] && startY <= rectangle[i][3]
               && endY >= rectangle[i][1] && endY <= rectangle[i][3]) {
                
                isIn = true;
                //상하 이동
                if(startX == endX) {
                    if(startX != rectangle[i][0] && startX != rectangle[i][2] ) {
                        return false;
                    } 
                } else {
                    if(startY != rectangle[i][1] && startY != rectangle[i][3] ) {
                        return false;
                    } 
                }
            
            }
            
        }
        return isIn;
    }
}

class Point {
    int x;
    int y;
    int count;
    
    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}