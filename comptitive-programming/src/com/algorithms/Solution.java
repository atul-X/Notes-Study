package algorithms;

import java.util.*;
import java.util.function.Function;

public class Solution {

    public int solution(String[] A, String[] B, int[] C) {

        int n = A.length;
        int BASE_YEAR = 1900;

        // Convert "MM-YYYY" → month index
        java.util.function.Function<String, Integer> toIndex = s -> {
            int month = Integer.parseInt(s.substring(0, 2));
            int year  = Integer.parseInt(s.substring(3, 7));
            return (year - BASE_YEAR) * 12 + (month - 1);
        };

        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;
        int[] start = new int[n];
        int[] end   = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = toIndex.apply(A[i]);
            end[i]   = toIndex.apply(B[i]);
            minIdx = Math.min(minIdx, start[i]);
            maxIdx = Math.max(maxIdx, end[i]);
        }

        int size = maxIdx - minIdx + 2;
        long[] diff = new long[size];

        // Range add using difference array
        for (int i = 0; i < n; i++) {
            int s = start[i] - minIdx;
            int e = end[i]   - minIdx;
            diff[s] += C[i];
            diff[e + 1] -= C[i];
        }

        long runningExpense = 0;
        long prefixExpense  = 0;
        long maxIncome = 0;
        int months = 0;

        for (int i = 0; i < size - 1; i++) {
            runningExpense += diff[i];   // expense this month
            prefixExpense  += runningExpense;
            months++;

            long needed = (prefixExpense + months - 1) / months; // ceil
            maxIncome = Math.max(maxIncome, needed);
        }

        return (int) maxIncome;
    }
    public int solution2(String[] A, String[] B, int[] C) {
        int n = A.length;

        int BASE_YEAR = 1900;
        Function<String,Integer> toIndex =s ->
        {
            int month=Integer.parseInt(s.substring(0,3));
            int year=Integer.parseInt(s.substring(3,7));
            return (year-BASE_YEAR)*12+(month-1);
        };
        int[] s=new int[n];
        int[] e=new int[n];
        int minIdx=Integer.MAX_VALUE;
        int maxIdx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            s[i]=toIndex.apply(A[i]);
            e[i]=toIndex.apply(B[i]);
            minIdx=Math.min(minIdx,s[i]);
            maxIdx=Math.max(maxIdx,e[i]);
        }

        int size=maxIdx-minIdx+2;
        long[] diff=new long[size];
        for (int i=0;i<n;i++){
            int si=s[i]-minIdx;
            int ei=e[i]-minIdx;
            diff[si]+=C[i];
            diff[ei+1]-=C[i];
        }
        long runningExpense=0;
        long prefixExpense=0;
        long maxIncome=0;
        int months=0;
        for (int i=0;i<size;i++){
            runningExpense+=diff[i];
            prefixExpense+=runningExpense;
            months++;
            long needed=(prefixExpense+months-1)/months;
            maxIncome=Math.max(maxIncome,needed);
        }
        return (int)maxIncome;

    }
    // ---------------- Binary Search Solution ----------------
    // ---------------- Helper Function ----------------
    //2099000107084521
    public int solutiona(String[] A, String[] B, int[] C){
        int n=A.length;
        int BASE_YEAR=1990;
        Function<String,Integer> toIndex =x->{
            int month=Integer.parseInt(x.substring(0,3));
            int year=Integer.parseInt(x.substring(3,7));
            return BASE_YEAR-year*12+month-1;
        };
        int[] s=new int[n];
        int[] e=new int[n];
        int minIdx=Integer.MAX_VALUE;
        int maxIdx=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            s[i]=toIndex.apply(A[i]);
            e[i]=toIndex.apply(B[i]);
            minIdx=Math.min(minIdx,s[i]);
            maxIdx=Math.max(maxIdx,e[i]);
        }

        int size=maxIdx-minIdx+2;
        int[] diff=new int[size];
        for (int i=0;i<size;i++){
            int si=s[i]-minIdx;
            int ei=e[i]-minIdx;
            diff[si]+=C[i];
            diff[ei+1]-=C[i];
        }
        long runningExpense=0;
        long prefixExpense=0;
        long months=0;
        long maxIncome=0;
        for (int i=0;i<size;i++){
            runningExpense+=diff[i];
            prefixExpense+=runningExpense;
            months++;
            long need=(prefixExpense+months-1)/months;
            maxIncome=Math.max(maxIncome,need);
        }
        return (int) maxIncome;

    }

    // Binary Search Solution - Test if a given income level works
    public int solutionBinary(String[] A, String[] B, int[] C) {
        int n = A.length;
        int BASE_YEAR = 1900;

        // Convert "MM-YYYY" → month index
        Function<String, Integer> toIndex = s -> {
            int month = Integer.parseInt(s.substring(0, 2));
            int year = Integer.parseInt(s.substring(3, 7));
            return (year - BASE_YEAR) * 12 + (month - 1);
        };

        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = toIndex.apply(A[i]);
            end[i] = toIndex.apply(B[i]);
            minIdx = Math.min(minIdx, start[i]);
            maxIdx = Math.max(maxIdx, end[i]);
        }

        int size = maxIdx - minIdx + 2;
        long[] diff = new long[size];

        // Range add using difference array
        for (int i = 0; i < n; i++) {
            int s = start[i] - minIdx;
            int e = end[i] - minIdx;
            diff[s] += C[i];
            diff[e + 1] -= C[i];
        }

        // Calculate monthly expenses
        long[] monthlyExpenses = new long[size - 1];
        long runningExpense = 0;
        for (int i = 0; i < size - 1; i++) {
            runningExpense += diff[i];
            monthlyExpenses[i] = runningExpense;
        }

        // Binary search for minimum valid income
        long left = 0, right = 0;
        for (long expense : monthlyExpenses) {
            right = Math.max(right, expense);
        }
        right *= 2; // Upper bound

        long result = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (isValidIncome(monthlyExpenses, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) result;
    }

    // Check if given income can cover all expenses
    private boolean isValidIncome(long[] expenses, long income) {
        long savings = 0;
        
        for (long expense : expenses) {
            savings += income - expense;
            if (savings < 0) {
                return false;
            }
        }
        return true;
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Solution sol = new Solution();

        // ✅ Test Case 1
        String[] A1 = {"03-2021", "04-2021", "05-2021"};
        String[] B1 = {"03-2021", "05-2021", "05-2021"};
        int[] C1 = {20, 10, 15};
        System.out.println("Test 1 Expected: 20 | Got: " + sol.solution(A1, B1, C1));
        System.out.println("Test 1 Binary Expected: 20 | Got: " + sol.solutionBinary(A1, B1, C1));

        // ✅ Test Case 2
        String[] A2 = {"10-2020", "01-2020", "02-2020", "06-2021"};
        String[] B2 = {"07-2021", "03-2020", "10-2020", "07-2021"};
        int[] C2 = {1, 10, 2, 90};
        System.out.println("Test 2 Expected: 13 | Got: " + sol.solution(A2, B2, C2));
        System.out.println("Test 2 Binary Expected: 13 | Got: " + sol.solutionBinary(A2, B2, C2));

        // ✅ Test Case 3
        String[] A3 = {"01-1900", "12-2099", "11-2099", "01-1901"};
        String[] B3 = {"12-1901", "12-2099", "12-2100", "01-1902"};
        int[] C3 = {1, 1000, 998, 1};
        System.out.println("Test 3 Expected: 7 | Got: " + sol.solution(A3, B3, C3));
        System.out.println("Test 3 Binary Expected: 7 | Got: " + sol.solutionBinary(A3, B3, C3));
    }
}