package algorithms.searching;

public class BinarySearch {

    public int search(int[] nums, int target){
        int left =0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target<nums[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }


    public static void  main(String[] args){
        int[] arr={1,3};
        BinarySearch binarySearch=new BinarySearch();
        int result =binarySearch.search(arr,0);
        System.out.print("result "+result);
    }
}
