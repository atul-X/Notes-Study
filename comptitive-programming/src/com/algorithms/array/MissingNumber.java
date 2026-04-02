package algorithms.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int count =nums.length;
        for (int j=nums.length-1;j>=0;j--){
            if (count==nums[j]){
                count--;
                continue;

            }
            break;
        }return count;
    }
    public static void main(String args[]){
    int[] arr={3,0,1};
    MissingNumber missingNumber=new MissingNumber();
    missingNumber.missingNumber(arr);
    }
}
