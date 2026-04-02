package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NRepeatedElement {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(nums[i]== nums[i+1]){
                return  nums[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,3};
        NRepeatedElement nRepeatedElement=new NRepeatedElement();
        nRepeatedElement.repeatedNTimes(arr);
    }
}
