package algorithms.backtracking;

import java.util.*;

public class StringContainsBinaryCode {
//    public boolean hasAllCodes(String s, int k) {
//        Set<String> ans=new HashSet<>();
//        StringBuilder sb=new StringBuilder();
//        genBacktrack(k,sb,ans);
//        boolean containsAll=true;
//        for (String b:ans){
//            if(!s.contains(b)){
//                return false;
//            }
//        }
//        return true;
//
//    }
    public boolean hasAllCodes(String s, int k) {
        int totalStrings=(int)Math.pow(2,k);
        Set<String> set=new HashSet();
        int index=0;
        while(index<s.length()){
            if(index+k<s.length()){
                set.add(s.substring(index,(index+k)));
            }
            index+=k;
        }
        if(totalStrings==set.size()){
            return true;
        }
        return false;
    }
    public int[] sortByBits(int[] arr) {
        return  Arrays.stream(arr).boxed().sorted((a,b)->{
                    int countABit=Integer.bitCount(a);
                    int countBBit =Integer.bitCount(b);
                    if (countABit!= countBBit){
                        return Integer.compare(countABit, countBBit);
                    }
                    return Integer.compare(a,b);
               }).mapToInt(Integer::intValue).toArray();
    }
    void genBacktrack(int k, StringBuilder s, Set<String> ans){
        if(s.length()==k){
            ans.add(s.toString());
            return;
        }
        for(int i=0;i<k;i++){
            genBacktrack(k,s.append(0),ans);
            s.deleteCharAt(s.length()-1);
            genBacktrack(k,s.append(1),ans);
            s.deleteCharAt(s.length()-1);
        }
    }




}
