package algorithms.sorting;

public class QuickSort {


    public int partition(int l,int h,int[] arr){
        int pivot =arr[l];
        int i=l;
        int j=h;
        while (i<j){
            while (arr[i]<=pivot && i!=arr.length-1) i++;
            while (arr[j]>=pivot && j!=0)j--;
            if(i<j){
                swap(i,j,arr);
            }
        }
        swap(j,l,arr);
        return j;
    }
    public void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void quicksrt(int l,int h,int[] arr){
        if(l<h){
            int pivot=partition(l,h,arr);
            quicksrt(l,pivot-1,arr);
            quicksrt(pivot+1,h,arr);

        }
    }

    public static void main(String[] args) {
        int[] arr ={3,5,4,2,4,6};
        QuickSort quickSort=new QuickSort();
        quickSort.quicksrt(0,arr.length-1,arr);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+"->");
        }
    }
}
