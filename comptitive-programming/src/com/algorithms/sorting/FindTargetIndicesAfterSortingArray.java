package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    int partition(int l,int h,int[] arr){
        int pivot=arr[l];
        int i=l;
        int j=h;
        while (i<j){
            while (arr[i]<=pivot && i!=arr.length-1) i++;
            while (arr[j]>=pivot && j!=0)j--;
            if (i<j){
                swap(i,j,arr);
            }
        }
        swap(j,l,arr);
        return j;
    }

    void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void quicksort(int l,int h,int[] arr){
        while (l<h){
            int pivot=partition(l,h,arr);
            quicksort(l,pivot-1,arr);
            quicksort(pivot+1,h,arr);
        }
    }


    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result=new ArrayList<>();
        quicksort(0,nums.length-1,nums);
        for (int i=0;i<nums.length;i++){
            if(nums[i]==target){
                result.add(i);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] arr={1,2,5,2,3};
        FindTargetIndicesAfterSortingArray findTargetIndicesAfterSortingArray=new FindTargetIndicesAfterSortingArray();
        findTargetIndicesAfterSortingArray.targetIndices(arr,2);
    }
}
