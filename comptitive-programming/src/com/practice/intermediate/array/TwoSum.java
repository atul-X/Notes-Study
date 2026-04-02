package practice.intermediate.array;

public class TwoSum {
    public int findTwoSum(int[] arr, int x){
            int start=0;
            int end=arr.length-1;
//            int[] arr1 = new int[2];
                int count=0;
            while (start<end){
                if (arr[start]+arr[end]==x){
//                    arr1[0] = start+1;
//                    arr1[1] = end+1;
                    count++;
                }
                if (arr[start]+arr[end]<x){
                    start++;
                }else {
                    end--;
                }
            }

        return count;
        }
//    public int[] findSumUnSortedArray(int arr[],int x){
//        int[] arr1 = new int[2];
//        int count=0;
//        for (int i=0;i<arr.length;i++){
//            for (int j=i+1;j<arr.length;j++){
//                if (count == 0) {
//                    if (arr[i] + arr[j] == x ) {
//                        arr1[0] = i;
//                        arr1[1] = j;
//                        count++;
//                        break;
//                    }
//                }
//
//            }
//
//        }
//        return arr1;
//    }
    public static void main(String[] args){
        int[] arr={1, 5, 7, 1};
        TwoSum twoSum=new TwoSum();
        int a1= twoSum.findTwoSum(arr,6);
        System.out.println(a1);
//        System.out.println("start  "+a1[0]+ " end "+a1[1]);
    }
}
