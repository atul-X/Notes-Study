package algorithms.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hashSetHashMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if (hashSetHashMap.containsKey(nums[i])) {
                Integer val=hashSetHashMap.get(nums[i]);
                val++;
                hashSetHashMap.put(nums[i],val);
            }else {
                hashSetHashMap.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> map:hashSetHashMap.entrySet()){
            if(map.getValue()==2) {
                continue;
            }
            if(map.getValue()%2==0){
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[ ] arr={3,2,3,2,2,2};
        DivideArrayIntoEqualPairs divideArrayIntoEqualPairs=new DivideArrayIntoEqualPairs();
        divideArrayIntoEqualPairs.divideArray(arr);
    }
}
