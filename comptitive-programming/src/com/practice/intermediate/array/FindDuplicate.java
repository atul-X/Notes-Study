package practice.intermediate.array;

import java.util.Arrays;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[]={1,3,4,2,2};
        FindDuplicate findDuplicate=new FindDuplicate();
        int a=findDuplicate.findDuplicate(arr);
        System.out.println(a);
    }
}
