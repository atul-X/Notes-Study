package practice.intermediate.array;

public class FindKthSmallestNumber {
    public int[] minimum(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++) {
                if (a[i] < a[j]) {
//                    minimum = a[j];
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
//            sortedArray[i]=minimum;
        }
        return a;
    }
    public int[] reverseArray(int[] arr){
        int b[]=new int[arr.length];
        for(int i=0 ;i< arr.length;i++){
            b[i]=arr[arr.length-i-1];
        }
        return b ;
    }
    public static void main(String args[]){
        int a[] ={33,2,34,5,4};
        int k=3;
        FindKthSmallestNumber findKthSmallestNumber=new FindKthSmallestNumber();
        int asa[]=findKthSmallestNumber.minimum(a);
//        int abv=miniMaxArr      ay.maximum(a);
//        int abv1=miniMaxArray.minimum(a);

//        System.out.println("maximum "+abv);
        int abv[]=findKthSmallestNumber.reverseArray(asa);
        if(abv.length<k){
            System.out.println();
        }
    }
}
