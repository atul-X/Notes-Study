package algorithms.string;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(A);
        String reverse=stringBuilder.reverse().toString();
        if(A.toLowerCase(Locale.ROOT).equals(reverse.toLowerCase(Locale.ROOT))){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    static boolean isAnagram(String a, String b) {
            // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
            char[] a1=a.toCharArray();
            char[] b1=b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        if(a1.equals(b1)){
            return true;
        }else {
            return false;
        }

    }







}
