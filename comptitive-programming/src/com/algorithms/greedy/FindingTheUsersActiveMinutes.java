package algorithms.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> hashSetHashMap=new HashMap<>();
        int[] result=new int[k];
        for(int i=0;i<logs.length;i++){
            int user=logs[i][0];
            int aum=logs[i][1];
            if(hashSetHashMap.containsKey(user)){
                HashSet<Integer> val=hashSetHashMap.get(user);
                val.add(aum);
            }else {
                HashSet<Integer> hashSet=new HashSet<>();
                hashSet.add(aum);
                hashSetHashMap.put(user,hashSet);
            }
        }
        for(Map.Entry<Integer,HashSet<Integer>> entry:hashSetHashMap.entrySet()){
            HashSet<Integer> val=entry.getValue();
            if(result[val.size()-1]==0){
                result[val.size()-1]=1;
            }else {
               int abc= result[val.size()-1];
               abc++;
               result[val.size()-1]=abc;
            }
        }


        return result;


    }



    public static void main(String[] args) {
        int[][] arr={{1,1},{2,2},{2,3}};
        FindingTheUsersActiveMinutes findingTheUsersActiveMinutes=new FindingTheUsersActiveMinutes();
        findingTheUsersActiveMinutes.findingUsersActiveMinutes(arr,4);
    }
}
