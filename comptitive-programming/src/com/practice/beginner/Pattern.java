package practice.beginner;

import java.util.Scanner;

public class Pattern {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        int[] a1=new int[256];
        Boolean isAnagramStr = null;
        if (a.length() != b.length()) {
            isAnagramStr=false;
        }
        isAnagramStr=true;
        for(char c:a.toCharArray()){
            int index=(int) c;
            a1[index]++;
        }
        for(char c:b.toCharArray()){
            int index=(int) c;
            a1[index]--;

        }
      for (int i=0;i<256;i++){
          if(a1[i]!=0){
              isAnagramStr= false;
              break;
          }
      }
        return   isAnagramStr ;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
