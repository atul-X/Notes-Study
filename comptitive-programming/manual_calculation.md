# Manual Calculation: How Input Becomes 20

## Given Input:
- A = ["03-2021", "04-2021", "05-2021"]
- B = ["03-2021", "05-2021", "05-2021"]  
- C = [20, 10, 15]

## Step 1: Understand What Each Array Means
- A[i] = Start month for expense C[i]
- B[i] = End month for expense C[i]
- C[i] = Monthly cost during that period

## Step 2: List All Expense Periods
1. **Period 1**: March 2021 to March 2021 → Cost: 20 per month
2. **Period 2**: April 2021 to May 2021 → Cost: 10 per month  
3. **Period 3**: May 2021 to May 2021 → Cost: 15 per month

## Step 3: Calculate Total Expenses Month by Month

**Month 1 (March 2021):**
- Active expenses: Period 1 only
- Total expense = 20
- Cumulative expense = 20
- Average so far = 20/1 = 20

**Month 2 (April 2021):**
- Active expenses: Period 2 only
- Total expense this month = 10
- Cumulative expense = 20 + 10 = 30
- Average so far = 30/2 = 15

**Month 3 (May 2021):**
- Active expenses: Period 2 (10) + Period 3 (15)
- Total expense this month = 10 + 15 = 25
- Wait, let me double-check this...

Actually, let me recalculate more carefully:

**Month 1 (March 2021):**
- Only Period 1 is active
- Expense = 20

**Month 2 (April 2021):**
- Only Period 2 is active  
- Expense = 10

**Month 3 (May 2021):**
- Period 2 is still active (10) + Period 3 starts (15)
- Expense = 10 + 15 = 25
- Cumulative expense = 20 + 10 + 25 = 55
- Average = 55/3 ≈ 18.33

## Step 4: Find Maximum Required Income
To never run out of money, you need enough income to cover the worst-case scenario.

- After Month 1: Need at least 20 (to cover 20 expense)
- After Month 2: Need at least 15 (to cover average of 30 over 2 months)
- After Month 3: Need at least 19 (to cover average of 55 over 3 months, rounded up)

## The Answer: 20
The highest amount you ever need is **20**, which is required in the first month.

## Why 20?
- In March, you have exactly 20 expense
- In April, your average drops to 15
- In May, your average is about 18.33
- Since you need a fixed monthly income, you must choose the maximum: 20
