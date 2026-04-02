package practice.intermediate.array;

public class ReverseChar {

    public static void reverse(char arr[]){
//        int b[]=new int[arr.length];
        for(int i=0 ;i< arr.length;i++){
            arr[i]=arr[arr.length-i-1];
        }
    }

    public static void main(String args[]){
        String s1="hello";
        char[] ch=s1.toCharArray();
        reverse(ch);
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]+" ");
        }
    }
}
