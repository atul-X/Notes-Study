package algorithms.array;

import java.util.Arrays;

public class CreateTargetArray {

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result=new int[nums.length];
        int sum=0;
        for (int i=0;i<index.length;i++){
            for(int j=index[i];j>=0;j--){
             sum+=nums[j];
            }
            result[index[i]]=sum;
            sum=0;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={0,1,2,3,4},index={0,1,2,2,1};
        CreateTargetArray createTargetArray=new CreateTargetArray();
        createTargetArray.createTargetArray(nums,index);
    }
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.abs((nums[nums.length-2]-1)*(nums[nums.length-1]-1));

    }
}
