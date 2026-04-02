package practice.intermediate.array;

import java.util.ArrayList;

public class LastEndFirst {
    public static ArrayList<Long> searchElement(int[] arr, int x){
        int start=-1;int end=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                if(start==-1){
                    start=i;
                }else {
                    end=i;
                }
            }
        }
        if (end==-1){
            end=start;
        }
        ArrayList<Long> arrayList=new ArrayList<>();

        if (start!=-1) {
            arrayList.add((long) Math.toIntExact(Long.valueOf(start)));
            arrayList.add((long) Math.toIntExact(Long.valueOf(end)));
            return arrayList;
        }else {
            arrayList.add((long) Math.toIntExact(Long.valueOf(-1)));
            arrayList.add((long) Math.toIntExact(Long.valueOf(-1)));
            return arrayList;

        }
//        return -1;
    }
    public static void main(String args[]){
        int arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
        int x = 7;
        ArrayList arrayList=searchElement(arr, x);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));

    }
}
