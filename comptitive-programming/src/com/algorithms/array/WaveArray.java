package algorithms.array;

public class WaveArray {

    public static int[] convertToWave(int[] arr, int n){
        for (int i=0;i<n;i++){
            if(i==n-1){
                continue;
            }
            int temp = 0;
            if(i%2==0){
                temp=arr[i];
                arr[i]=arr[i+1];
                 arr[i+1]=temp;
            }
        }
        return arr;
    }
    public static int sumElement(int arr[], int n)
    {
        // Your code
        int sum =0;
        for (int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b=convertToWave(a, a.length);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
