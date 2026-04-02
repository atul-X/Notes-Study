package algorithms.array;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] arr=new int[nums.length];
        int count=0;
        int temp=n;
        for(int i=0;i<n;i++){
            arr[count]=nums[i];
            count++;
            arr[count]=nums[temp];
            count++;
            temp++;
        }
        return arr;
    }
    public static void main(String args[]){
    int[] arr={2,5,1,3,4,7};
    ShuffleArray shuffleArray=new ShuffleArray();
    shuffleArray.shuffle(arr,3);
    }
}
