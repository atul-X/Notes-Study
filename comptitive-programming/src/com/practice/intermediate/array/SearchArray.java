package practice.intermediate.array;

public class SearchArray {
    static int binareySecrh(int arr[],int low,int high,int value){
        int mid=low+(high-low)/2;
        if (high>=low) {
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value) {
                return binareySecrh(arr, low, mid-1, value);
            }
            return binareySecrh(arr,mid+1 , high, value);
        }
        return -1;
    }
public static void main(String[] args){
    int arr[] = { 2, 3, 4, 10 };
    int n = arr.length;
    int x = 10;
    int pos=binareySecrh(arr,0,n-1,x);
    System.out.println(pos);
    }
}
