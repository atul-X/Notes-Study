# Brute Force Approach for This Problem

## Problem Understanding
Given expense periods with monthly costs, find the minimum fixed monthly income needed to never run out of money.

## Brute Force Strategy
Try every possible monthly income amount and check if it works.

## Step-by-Step Brute Force Algorithm

### Step 1: Parse Input
Convert all dates to month indices for easier calculation.

### Step 2: Find Time Range
Find the earliest and latest months to know our time span.

### Step 3: Try All Possible Income Values
For each possible income amount from 1 to some reasonable maximum:

1. **Initialize**: balance = 0
2. **For each month** in the time range:
   - Add income to balance
   - Subtract all expenses for that month
   - If balance < 0 at any point → this income is too low
3. **If balance never goes negative** → this income works!

### Step 4: Return Minimum Working Income
The first income amount that works is our answer.

## Example with Test Case 1

### Input:
- A = ["03-2021", "04-2021", "05-2021"]
- B = ["03-2021", "05-2021", "05-2021"]  
- C = [20, 10, 15]

### Step 1: Convert to Months
- Period 1: March 2021, cost = 20
- Period 2: April-May 2021, cost = 10
- Period 3: May 2021, cost = 15

### Step 2: Try Income = 1
- March: balance = 1 - 20 = -19 ❌ (negative!)

### Step 3: Try Income = 2
- March: balance = 2 - 20 = -18 ❌

### Step 4: ... Keep Trying ...

### Step 5: Try Income = 19
- March: balance = 19 - 20 = -1 ❌

### Step 6: Try Income = 20
- March: balance = 20 - 20 = 0 ✅
- April: balance = 0 + 20 - 10 = 10 ✅
- May: balance = 10 + 20 - (10 + 15) = 5 ✅
- **Never negative!** → Income = 20 works!

### Answer: 20

## Brute Force Code Structure

```java
public int bruteForce(String[] A, String[] B, int[] C) {
    // Step 1: Parse dates and find time range
    int minMonth = findMinMonth(A);
    int maxMonth = findMaxMonth(B);
    
    // Step 2: Try all possible incomes
    for (int income = 1; income <= MAX_POSSIBLE; income++) {
        if (works(income, A, B, C, minMonth, maxMonth)) {
            return income;
        }
    }
    return -1;
}

private boolean works(int income, String[] A, String[] B, int[] C, 
                      int minMonth, int maxMonth) {
    long balance = 0;
    
    for (int month = minMonth; month <= maxMonth; month++) {
        balance += income;
        
        // Subtract all expenses for this month
        for (int i = 0; i < A.length; i++) {
            if (month >= getMonth(A[i]) && month <= getMonth(B[i])) {
                balance -= C[i];
            }
        }
        
        if (balance < 0) return false;
    }
    return true;
}
```

## Time Complexity
- Outer loop: O(MaxIncome) 
- Inner loops: O(NumMonths × NumExpenses)
- Total: O(MaxIncome × NumMonths × NumExpenses)

## Why This is Brute Force
- We try every possible income value sequentially
- No optimization or mathematical insight
- Guaranteed to find the answer but very slow for large inputs
