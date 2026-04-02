package algorithms.array;

public class RunningSumArray {
    public int[] runningSum(int[] nums) {
        int currentSum=0;
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            arr[i]=currentSum;
        }
        return arr;
    }
    public static void main(String args[]){

    }
}
