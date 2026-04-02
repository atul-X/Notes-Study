package practice.intermediate.array;

public class MinimumNumberOfStep {
    static int minimumStep(int[] arr){
        int maxrange=arr[0],steps=arr[0],jumps=1;
        if (arr.length<=1){
            return 0;
        }
        if(arr[0]==0){
            return -1;
        }
        for (int i=1;i<arr.length;i++){
            if(i==arr.length-1){
                return jumps;
            }
            maxrange = Math.max(maxrange,i+arr[i]);
            steps--;
             if (steps == 0) {
                 jumps++;
                   if(i>=maxrange) {
                       return -1;
                   }
                   steps = maxrange - i;
             }

        }
        return -1;
    }
    public static void main(String args[]){
        int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int a=minimumStep(arr);
        System.out.println(a);
    }
}
