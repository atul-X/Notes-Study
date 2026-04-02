package algorithms.sorting;

import java.util.Arrays;

public class MinimizeMaximumPairSuminArray {
//    public int partition(int l,int h ,int[] arr){
//        int pivot= arr[l];
//        int i=l;
//        int j=h;
//        while (i<j) {
//            while (arr[i] <= pivot && i != arr.length - 1) {
//                i++;
//            }
//            while (arr[j] >= pivot && j != 0) {
//                j--;
//            }
//            if (i < j) {
//                swap(i, j, arr);
//            }
//        }
//        swap(j,l ,arr);
//        return j;
//    }
//
//    public void quicksort(int l,int h,int[] arr){
//        if (l<h){
//            int pivot=partition(l,h,arr);
//            quicksort(l,pivot-1,arr);
//            quicksort(pivot+1,h,arr);
//
//        }
//    }
//
//    public void swap(int i, int j,int[] arr ){
//        int temp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=temp;
//    }
//
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int high=nums.length-1;
        int[] countArr=new int[nums.length/2];
        for(int i=0;i<=Math.abs(nums.length/2)-1;i++){
            int a=nums[i];
            int b=nums[high];
            int c=a+b;
            countArr[i]=c;
            high--;
        }

        int sum=0;
        for(int i=0;i<countArr.length;i++){
            sum= Math.max(sum,countArr[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr={3,5,4,2,4,6};
        MinimizeMaximumPairSuminArray minimizeMaximumPairSuminArray=new MinimizeMaximumPairSuminArray();
        minimizeMaximumPairSuminArray.minPairSum(arr);
    }
}
