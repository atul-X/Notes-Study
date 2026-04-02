package algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class LogestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int j=0;
        int z=0;
        if(s.length()==0){
            return 0;
        }
        List<Integer> logestString=new ArrayList<>();
        for (int i=0;i<s.length()-1;i++){
            if(s.charAt(j)!=s.charAt(j+1)){
                z++;
                j++;
            }
            if(s.charAt(j)==s.charAt(j+1)){
                logestString.add(z);
                z=0;
            }
        }
        return 0;
    }
    public static void main(String argd[]){
        lengthOfLongestSubstring("abcabcbb");
    }
}
