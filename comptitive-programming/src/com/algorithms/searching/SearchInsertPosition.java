//package algorithms.searching;
//
//public class SearchInsertPosition {
//
//    public int searchInsert(int[] nums, int target) {
//        int left=0,right=nums.length;
//        while (left<right){
//            int mid=(left+right)/2;
//            if(nums[mid]==target){
//                return mid;
//            }
//            if(target<nums[mid]){
//                left=mid-1;
//            }
//            else
//                left=mid+1;
//        }
//        return m
//    }
//
//
//    public static void main(String args[]){
//        int[] arr={1,3,5,6};
//        SearchInsertPosition searchInsertPosition=new SearchInsertPosition();
//        searchInsertPosition.searchInsert(arr,5);
//    }
//}
