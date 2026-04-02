package algorithms.searching;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
            public static String getMd5(String input)
            {
                try {

                    // Static getInstance method is called with hashing MD5
                    MessageDigest md = MessageDigest.getInstance("MD5");

                    // digest() method is called to calculate message digest
                    // of an input digest() return array of byte
                    byte[] messageDigest = md.digest(input.getBytes());

                    // Convert byte array into signum representation
                    BigInteger no = new BigInteger(1, messageDigest);

                    // Convert message digest into hex value
                    String hashtext = no.toString(16);
                    while (hashtext.length() < 32) {
                        hashtext = "0" + hashtext;
                    }
                    return hashtext;
                }

                // For specifying wrong message digest algorithms
                catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }

            // Driver code
            public static void main(String[] args) throws NoSuchAlgorithmException
            {
                Scanner scanner=new Scanner(System.in);
                String a =scanner.next();
                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(a);
                boolean b = m.find();

                if (b) {
                    System.out.println("There is a special character in my string");
                }
                else {
                    System.out.println(getMd5(a));
                }
            }
        }
