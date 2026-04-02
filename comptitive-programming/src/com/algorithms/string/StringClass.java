package algorithms.string;

import java.util.Scanner;

public class StringClass {



        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            String B=sc.next();
            /* Enter your code here. Print output to STDOUT. */
            int c=  A.length()+B.length();
            System.out.println(c);
            System.out.println("No");
            System.out.println(A.substring(0,1).toUpperCase()+A.substring(1,A.length())+" "+B.substring(0,1)+B.substring(1,B.length()));
        }
    }


