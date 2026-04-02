# Finding the Maximum Income for Brute Force

## What Should Be the Maximum Income to Try?

## Option 1: Sum of All Monthly Expenses
The worst case is when ALL expenses are active in the same month.

### Test Case 1:
- Period 1: 20 (March only)
- Period 2: 10 (April-May)  
- Period 3: 15 (May only)
- Maximum simultaneous expenses = 10 + 15 = 25
- But wait, in March only 20 is active...

Actually, the maximum needed is the maximum of:
- Single month expense: 20 (March)
- Combined expenses: 10 + 15 = 25 (May)

So MAX = 25

## Option 2: Total Cumulative Expenses
Sum all expenses over their entire duration.

### Test Case 1:
- Period 1: 20 × 1 month = 20
- Period 2: 10 × 2 months = 20  
- Period 3: 15 × 1 month = 15
- Total = 20 + 20 + 15 = 55
- Average over 3 months = 55/3 ≈ 18.33
- But this is less than individual months...

## Option 3: Maximum Single Month Expense
Just take the maximum C[i] value.

### Test Case 1:
- Max C[i] = max(20, 10, 15) = 20
- This works for this case!

## Option 4: Conservative Upper Bound
Take the sum of all C[i] values.

### Test Case 1:
- Sum = 20 + 10 + 15 = 45
- This is definitely safe but might be too high.

## Which One is Correct?

The correct maximum is the **maximum expense in any single month**.

### Why?
- If you can handle the most expensive month, you can handle all others
- The answer is the maximum of cumulative averages, not individual expenses

### For Test Case 1:
- March: 20
- April: 10  
- May: 10 + 15 = 25
- Maximum monthly expense = 25

But the actual answer is 20, not 25!

## The Real Answer
The maximum income needed is actually the **maximum cumulative average**, not the maximum monthly expense.

So for brute force, a safe upper bound would be:
- Maximum monthly expense (when all periods overlap)
- OR sum of all C[i] values (very conservative)

## Recommended MAX for Brute Force:
```java
int maxIncome = 0;
for (int cost : C) {
    maxIncome += cost;  // Sum of all costs (safe upper bound)
}
```

For Test Case 1: maxIncome = 20 + 10 + 15 = 45

This guarantees we'll find the answer (20) within our search range.
