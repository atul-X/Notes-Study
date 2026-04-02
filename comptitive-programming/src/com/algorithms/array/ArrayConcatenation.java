package algorithms.array;

public class ArrayConcatenation {
    public int[] getConcatenation(int[] nums) {
       int count=0;
       int[] arr=new int[nums.length*2];
        for(int i=0;i<2;i++){
            for (int j=0;j<nums.length;j++){
                arr[count]=nums[i];
                count++;
            }
        }
        return arr;
    }
    public static void main(String args[]){

    }
 }
