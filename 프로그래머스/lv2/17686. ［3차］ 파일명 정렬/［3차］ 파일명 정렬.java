import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<file> changedFile = new ArrayList<>();
        
        for(String i : files) {
            changedFile.add(new file(i));
        }
        
        Collections.sort(changedFile, new MultiComp());
        
        for(int i = 0; i < changedFile.size(); i++) {
            answer[i] = changedFile.get(i).fileName;
        }
        
        return answer;
    }
}

class file {
    
    private String head = "";
    private int number = 0;
    String fileName = "";
    
    file(String str) {
        String num = "";
        
        fileName = str;
        for(int i = 0; i < str.length(); i++) {
            if(num.equals("") && !Character.isDigit(str.charAt(i))) {
                head += str.charAt(i);
            }else if(!num.equals("") && !Character.isDigit(str.charAt(i))) {
                break;
            }else if(Character.isDigit(str.charAt(i))) {
                num += str.charAt(i);
            }
        }
        
        number = Integer.parseInt(num);
        head = head.toUpperCase();
    }
    
    public void printNum() {
        System.out.println(fileName);
    }
    
    public String getHead() { return head; }
    
    public int getNum() { return number;}
    
}

class MultiComp implements Comparator< file > {
    public MultiComp() {
        super();
    }
    
    @Override
    public int compare(file f1, file f2) {
        String n1 = f1.getHead();
        String n2 = f2.getHead();
        
          
        if(n1.compareTo(n2) > 0) {
            return 1;
        } else if (n1.compareTo(n2) < 0) {
            return -1;
        } else {
            return f1.getNum() - f2.getNum();
        }
    }
}