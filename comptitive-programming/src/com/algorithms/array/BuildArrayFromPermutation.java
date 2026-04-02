package algorithms.array;

public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i< nums.length;i++){
            int index=nums[i];
            arr[i]=nums[index];
        }
        return arr;
    }
    public static void main(String args[]){
        int[] a={2,4,9,3};
        BuildArrayFromPermutation buildArrayFromPermutation=new BuildArrayFromPermutation();
        buildArrayFromPermutation.decrypt(a,-2);
    }

    public int[] decrypt(int[] code, int k) {
        int[] arr=new int[code.length];
        int count=0;
        int sum=0;
        for(int i=0;i<code.length;i++){
            for(int j=0;j<Math.abs(k);j++){
                if(k==0){
                    arr[i]=0;
                }else if(code[i]>k){
                    if(j==0){
                        count=i+1;
                        if(count==code.length){
                            count=0;
                        }
                    }
                    if(count==code.length){
                        count=0;
                    }
                    sum=sum+code[count];
                    count++;
                }else{
                    if(j==0){
                        if(i==0){
                            count=code.length-1;
                        }else {
                            count=i-1;
                        }
                    }
                    if(count<0){
                        count=code.length-1;
                    }
                    sum=sum+code[count];
                    count--;
                }


            }
            arr[i]=sum;
            sum=0;
            count=0;
        }
        return arr;
    }
}
