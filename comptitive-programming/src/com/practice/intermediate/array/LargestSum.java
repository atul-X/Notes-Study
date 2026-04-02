package practice.intermediate.array;

public class LargestSum {
    public int largestSum(int arr[]){
        int max_so_far = 0,max_ending_here=0;
        for (int i=0;i<arr.length;i++){
            max_ending_here+=arr[i];
            if(max_so_far<max_ending_here){
                max_so_far=max_ending_here;
            }else if(max_ending_here<0){
                max_ending_here=0;
            }
        }
        return max_so_far;

    }
    public static void main(String args[]){
        int a[] ={1,2,3,-2,5};
        LargestSum largestSum=new LargestSum();
        int aaa=largestSum.largestSum(a);
        System.out.println(aaa);
    }
}
