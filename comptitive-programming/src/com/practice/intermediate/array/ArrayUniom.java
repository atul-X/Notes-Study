package practice.intermediate.array;

import java.util.HashSet;

public class ArrayUniom {
    int doUnion(int a[], int n, int b[], int m)  {
        HashSet hashSet=new HashSet();
//        HashSet hashSet1=new HashSet();
        for (int i=0;i<a.length;i++){
            hashSet.add(a[i]);
        }
        for (int i=0;i<b.length;i++) {

            hashSet.add(b[i]);
        }
        return hashSet.size();
    }
    public static void main(String args[]){
        int a[] ={1,2,3,4,5};
        int b[] ={1,2,3};
        ArrayUniom arrayUniom=new ArrayUniom();
        int aa=arrayUniom.doUnion(a,a.length,b,b.length);
        System.out.println(aa);
    }
}
