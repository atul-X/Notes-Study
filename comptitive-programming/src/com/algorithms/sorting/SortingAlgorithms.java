package algorithms.sorting;

public class SortingAlgorithms {
    /*
    * Bubble sort
    * Algorithm	Time Complexity
 	*               Best	Average	Worst
    *  Bubble Sort	Ω(n)	θ(n^2)	O(n^2)
    *
    * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. This algorithm is not suitable for large data sets as its average and worst case time complexity is quite high.

    *How Bubble Sort Works?
    *Consider an array arr[] = {5, 1, 4, 2, 8}

    * First Pass:

    * Bubble sort starts with very first two elements, comparing them to check which one is greater.
    * ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
    * ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
    * ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
    * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
    * Second Pass:

    * Now, during second iteration it should look like this:
    * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
    * ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
    * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    * ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
    * Third Pass:

    * Now, the array is already sorted, but our algorithm does not know if it is completed.
    * The algorithm needs one whole pass without any swap to know it is sorted.
    * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
    * */
    public void bubbleSort(int[ ] arr){
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=0;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }

    }
    public void selectionSort(int[ ] arr){

        for(int i=0;i<arr.length-1;i++) {
            int smallestElementIndex=i;
            for (int j = i+1; j < arr.length - 1; j++) {
                if (arr[j] < arr[smallestElementIndex]) {
                    smallestElementIndex=j;
                }
            }

            int temp=arr[smallestElementIndex];
            arr[smallestElementIndex]=arr[i];
            arr[i]=temp;
        }

    }
    public void insertionSort(){

    }
    public void mergesort(){

    }
    public void quickSort(){

    }
    public void radixSort(){

    }
    public void  bucketSort(){

    }
    public void heapSort(){

    }
    public static void main(String args[]){
        int[] arr={5,3,6,4,7,1};
        SortingAlgorithms sortingAlgorithms=new SortingAlgorithms();
//        sortingAlgorithms.bubbleSort(arr);
        System.out.println(arr);
        sortingAlgorithms.selectionSort(arr);
        System.out.println(arr);
    }

}
