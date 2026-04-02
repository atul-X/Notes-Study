package com.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> arr=new ArrayList<>();
        int max=candies[0];
        for (int i=0;i<candies.length;i++){
            if(max<candies[i]){
                max=candies[i];
            }
        }

        for (int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                arr.add(true);
            }
            arr.add(false);
        }
        return arr;
    }
    public static void main(String args[]){
        KidsWithGreatestCandies solution = new KidsWithGreatestCandies();
        
        // Test case
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        
        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);
        System.out.println("Kids with greatest candies: " + result);
    }
}
