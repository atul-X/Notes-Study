package practice.intermediate.array;

import java.util.Locale;

public class Palindrome {
    int isPlaindrome(String A) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(A);
        String reverse=stringBuilder.reverse().toString();
        if(A.toLowerCase(Locale.ROOT).equals(reverse.toLowerCase(Locale.ROOT))){
            return  1;
        }else {
            return 0;
        }
    }

    public static void main(String args[]){

    }
}
