package algorithms.searching;

public class BinearySearch {
    int binarysearch(int arr[], int n, int k){
        int a=search(arr,0,n-1,k);
        return a;
    }

    int search(int arr[],int l,int r,int k){
        if (l<r){
            int mid=l+(r-1)/2;
            if(arr[mid]==k){
                return k;
            }
            if(k<arr[mid]){
                return search(arr ,l,mid-1,k);
            }
            return search(arr,mid+1,r,k);
        }
        return -1;
    }
    public static void main(String args[]){


    }
}
