package com.algorithms.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxWordsInSentences {
    public int mostWordsFound(String[] sentences) {
        int maxSum=0; int currentSum=0;
        for(int i=0;i<sentences.length;i++){
            String sentence =sentences[i];
            String arr[]= sentence.split(" ");
            for (int j=0;j<arr.length;j++) {
                currentSum++;
                if (currentSum >= maxSum) {
                    maxSum = currentSum;
                }
            }
            currentSum=0;
        }
        return maxSum;
    }
    public String replaceCharAtIndex(String s, int index, char newChar) {
        if (index < 0 || index >= s.length()) {
            return s; // Return original string if index is invalid
        }
        char[] chars = s.toCharArray();
        chars[index] = newChar;
        return new String(chars);
    }



    public static void main(String args[]){
        MaxWordsInSentences solution = new MaxWordsInSentences();
        
        // Index-based string replacement example
        String s = "1011";
        String replaced = solution.replaceCharAtIndex(s, 1, '1'); // Replace character at index 1
        System.out.println("Original string: " + s);
        System.out.println("After replacing char at index 1 with '1': " + replaced);
        
        // Test case
        String[] sentences = {
            "alice and bob are playing",
            "this is a test sentence",
            "the quick brown fox jumps over the lazy dog"
        };
        
        int result = solution.mostWordsFound(sentences);
        System.out.println("Maximum words in a sentence: " + result);
    }
}
