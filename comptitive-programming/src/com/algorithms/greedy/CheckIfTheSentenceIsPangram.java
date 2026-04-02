package algorithms.greedy;

import java.util.HashSet;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        HashSet<String> hashSet=new HashSet<String>();
        for(int i=0;i<sentence.length();i++){
          char var=  sentence.charAt(i);
          hashSet.add(String.valueOf(var));
        }
        if(hashSet.size()==26){
            return true;
        }
        return false;
    }
}
