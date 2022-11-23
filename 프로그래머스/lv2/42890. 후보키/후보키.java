import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    static ArrayList<HashSet<Integer>> answerArray = new ArrayList<>();
    
    public int solution(String[][] relation) {
        
        boolean[] visited = new boolean[relation[0].length];
        
        for(int i = 1; i <= relation[0].length; i++) {
            combination(relation, 0, relation[0].length, visited, i);
        }
        
        return answerArray.size();
    }
    
    public static void combination(String[][] arr, int start, int size, boolean[] visited, int n) {
        
        if(n == 0) {
            isCandidate(arr, visited, size);
            return;
        }
        
        for(int i = start; i < size ; i++ ) {
            visited[i] = true;
            combination(arr, i + 1, size, visited, n - 1);
            visited[i] = false;
        }
        
    }
    
    public static void isCandidate(String[][] arr, boolean[] visited, int size) {
        ArrayList<String[]> s = new ArrayList<>();
        HashSet<Integer> a = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            String[] temp = new String[size];
            for(int j = 0; j < size; j++) {
                if(visited[j]) temp[j] = arr[i][j];
                else temp[j] = "-";
            }
            for(int k = 0; k < s.size() ; k++) {
            
                for(int j = 0; j < size; j++) {
                    
                    if(!s.get(k)[j].equals(temp[j])) break;
                    else if(j == size - 1) return;
                }
            }
            s.add(temp);
        }
        
        for(int i = 0; i<size; i++) {
            if(visited[i]) a.add(i);
        }
        
        
        if(answerArray.size() == 0) {
            answerArray.add(a);
        }else  {
            for(int i = 0; i < answerArray.size(); i++) {
                if(a.containsAll(answerArray.get(i))) break;
                else if(i == answerArray.size() - 1) {
                     answerArray.add(a);
                }
            }
        }

        
        return;
    }
}