package algorithms.array;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result=new int[nums.length];
        int count=0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    count++;
                }
            }
            result[i]=count;
            count=0;
        }

        return  result;
    }


    public static void main(String args[]){
        int[] arr={8,1,2,2,3};
        HowManyNumbersAreSmallerThanTheCurrentNumber howManyNumbersAreSmallerThanTheCurrentNumber=new HowManyNumbersAreSmallerThanTheCurrentNumber();
        howManyNumbersAreSmallerThanTheCurrentNumber.smallerNumbersThanCurrent(arr);
    }
}
