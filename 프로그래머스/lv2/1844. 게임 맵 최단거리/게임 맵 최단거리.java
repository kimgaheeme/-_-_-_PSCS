import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    
    public int solution(int[][] maps) {
        int n = maps[0].length;
        int m = maps.length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,0));
        visited[0][0] = true;
            
        while(queue.size() != 0) {
            Point now = queue.removeFirst();;
        
            for(int i = 0; i< 4 ; i++) {
                
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                int count = now.count + 1;
                
                if(newX >= 0 && newX < n && newY >= 0 && newY < m &&
                    !visited[newY][newX] && 
                  maps[newY][newX] != 0){
                    if(newX == n - 1 && newY == m - 1) return count + 1;
                    queue.add(new Point(newX, newY, count));
                    visited[newY][newX] = true;
                }
            }
        }
        
        
        return -1;
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
