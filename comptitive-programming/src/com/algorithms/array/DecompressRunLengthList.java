package algorithms.array;

public class DecompressRunLengthList {
    public int[] decompressRLElist(int[] nums) {
        int countfreq=0;
        for (int z=0;z<=nums.length-1;z++){
            countfreq+=nums[z];
            z++;
        }
        int[]  arr=new int[countfreq];
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            int freq=nums[i];
            int val=nums[i+1];
            for(int j=0;j<freq;j++){
                arr[count]=val;
                count++;
            }
            i++;
        }

        return arr;
    }
    public static void main(String args[]){
        int[] arr={1,2,3,4};
        DecompressRunLengthList decompressRunLengthList=new DecompressRunLengthList();
        decompressRunLengthList.decompressRLElist(arr);
    }
}
