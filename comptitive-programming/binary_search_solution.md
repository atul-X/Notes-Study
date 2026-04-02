# Binary Search Solution for This Problem

## Why Binary Search Works Here
The problem has a **monotonic property**:
- If income X works, then any income > X also works
- If income X doesn't work, then any income < X also doesn't work

This makes it perfect for binary search!

## Binary Search Algorithm

### Range:
- **Low**: 0
- **High**: sum of all expenses (safe upper bound)

### Process:
1. **mid = (low + high) / 2**
2. **Test if mid works** (simulate with that income)
3. **If works**: high = mid - 1 (try lower)
4. **If doesn't work**: low = mid + 1 (need higher)
5. **Answer**: low (first income that works)

## Example with Test Case 1

### Input:
- A = ["03-2021", "04-2021", "05-2021"]
- B = ["03-2021", "05-2021", "05-2021"]  
- C = [20, 10, 15]
- Range: low = 0, high = 45

### Binary Search Steps:

**Step 1:**
- mid = (0 + 45) / 2 = 22
- Test income = 22:
  - March: 22 - 20 = 2 ✅
  - April: 2 + 22 - 10 = 14 ✅
  - May: 14 + 22 - 25 = 11 ✅
  - **Works!** → high = 21

**Step 2:**
- mid = (0 + 21) / 2 = 10
- Test income = 10:
  - March: 10 - 20 = -10 ❌
  - **Doesn't work!** → low = 11

**Step 3:**
- mid = (11 + 21) / 2 = 16
- Test income = 16:
  - March: 16 - 20 = -4 ❌
  - **Doesn't work!** → low = 17

**Step 4:**
- mid = (17 + 21) / 2 = 19
- Test income = 19:
  - March: 19 - 20 = -1 ❌
  - **Doesn't work!** → low = 20

**Step 5:**
- mid = (20 + 21) / 2 = 20
- Test income = 20:
  - March: 20 - 20 = 0 ✅
  - April: 0 + 20 - 10 = 10 ✅
  - May: 10 + 20 - 25 = 5 ✅
  - **Works!** → high = 19

**Step 6:**
- Now low = 20, high = 19
- **Loop ends, answer = low = 20**

## Binary Search Code Structure

```java
public int binarySearchSolution(String[] A, String[] B, int[] C) {
    int low = 0;
    int high = 0;
    for (int cost : C) {
        high += cost;  // Sum of all costs
    }
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (works(mid, A, B, C)) {
            high = mid - 1;  // Try lower income
        } else {
            low = mid + 1;   // Need higher income
        }
    }
    
    return low;
}

private boolean works(int income, String[] A, String[] B, int[] C) {
    // Same simulation as brute force
    long balance = 0;
    int minMonth = findMinMonth(A);
    int maxMonth = findMaxMonth(B);
    
    for (int month = minMonth; month <= maxMonth; month++) {
        balance += income;
        
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

## Detailed Explanation of works() Function

### Purpose
Tests if a given monthly income is sufficient to cover all expenses without ever going negative.

### Step-by-Step Breakdown:

#### 1. **Initialization**
```java
long balance = 0;
```
- Start with zero money
- Use `long` to prevent overflow with large numbers

#### 2. **Find Time Range**
```java
int minMonth = findMinMonth(A);  // When expenses start
int maxMonth = findMaxMonth(B);  // When expenses end
```
- For Test Case 1: minMonth = 1454 (March), maxMonth = 1456 (May)

#### 3. **Month-by-Month Simulation**
```java
for (int month = minMonth; month <= maxMonth; month++) {
```
- Loop through each month from March to May
- month = 1454, 1455, 1456

#### 4. **Add Income**
```java
balance += income;
```
- Add the fixed monthly income to balance
- If income = 20: balance becomes 20, then 40, then 60...

#### 5. **Subtract All Active Expenses**
```java
for (int i = 0; i < A.length; i++) {
    if (month >= getMonth(A[i]) && month <= getMonth(B[i])) {
        balance -= C[i];
    }
}
```

**What this does:**
- For each expense period (i = 0, 1, 2)
- Check if current month is within that expense period
- If yes, subtract that expense from balance

**Example for month = 1456 (May):**
- Period 0: May >= March && May <= March? ❌ (No)
- Period 1: May >= April && May <= May? ✅ (Yes) → balance -= 10
- Period 2: May >= May && May <= May? ✅ (Yes) → balance -= 15

## Why We Need the Double Loop

### **Outer Loop** (months)
```
for (int month = minMonth; month <= maxMonth; month++)
```
- Goes through each month: March, April, May
- This is **time progression**

### **Inner Loop** (expenses)
```
for (int i = 0; i < A.length; i++)
```
- For each month, checks ALL expense periods
- This is **expense checking**

### **Why Can't We Use Single Loop?**

**Problem:** Multiple expenses can be active in the same month!

**Test Case 1 Example:**
- **March**: Only Period 1 (cost 20)
- **April**: Only Period 2 (cost 10)  
- **May**: Period 2 + Period 3 (cost 10 + 15 = 25)

**If we used single loop:**
```java
// WRONG - This would only check one expense per month
for (int month = minMonth; month <= maxMonth; month++) {
    balance += income;
    // Which expense do we check? We need to check ALL!
}
```

**With double loop:**
```java
// CORRECT - Check ALL expenses for EACH month
for (int month = minMonth; month <= maxMonth; month++) {  // March, April, May
    balance += income;
    
    for (int i = 0; i < A.length; i++) {  // Check all 3 expense periods
        if (month >= getMonth(A[i]) && month <= getMonth(B[i])) {
            balance -= C[i];  // Subtract if this expense is active
        }
    }
}
```

### **Real-World Analogy**
Think of it like:
- **Outer loop**: Each day of the month
- **Inner loop**: All your bills that need to be paid that day

You need to check **all bills** for **each day**, not just one bill per day!

### **Complexity of works() Function**
- **Outer loop**: 3 months (March, April, May)
- **Inner loop**: 3 expense periods
- **Total operations**: 3 × 3 = 9 checks

This is necessary to accurately calculate the total expenses for each month.

## Time Complexity Analysis

### **works() Function Complexity**
```
O(NumMonths × NumExpenses)
```

**For Test Case 1:**
- NumMonths = 3 (March, April, May)
- NumExpenses = 3
- **works() complexity = 3 × 3 = 9 operations**

### **Binary Search Overall Complexity**
```
O(log(MaxIncome) × NumMonths × NumExpenses)
```

**For Test Case 1:**
- MaxIncome = 45 (sum of all costs)
- log₂(45) ≈ 6
- NumMonths = 3
- NumExpenses = 3
- **Total = 6 × 3 × 3 = 54 operations**

### **Comparison with Other Approaches**

#### **Brute Force**
```
O(MaxIncome × NumMonths × NumExpenses)
```
- 45 × 3 × 3 = 405 operations
- Tests EVERY income from 0 to 45

#### **Binary Search**
```
O(log(MaxIncome) × NumMonths × NumExpenses)
```
- 6 × 3 × 3 = 54 operations
- Tests only ~6 incomes (22, 10, 16, 19, 20)

#### **Optimized Solution (Original Code)**
```
O(NumMonths + NumExpenses)
```
- 3 + 3 = 6 operations
- Uses difference array technique

## Optimized Approach Explained

### **The Original Solution's Strategy**
Instead of checking every expense for every month (double loop), the optimized solution uses a **difference array** to pre-calculate all expenses in linear time.

### **Key Innovation: Difference Array**

#### **What is a Difference Array?**
A clever way to handle range updates in O(1) time instead of O(range length).

#### **How It Works:**
1. **Instead of**: Adding expense C[i] to every month in range [start, end]
2. **We do**: 
   - Add C[i] to `diff[start]`
   - Subtract C[i] from `diff[end+1]`
3. **Later**: Convert back to actual values with prefix sum

### **Step-by-Step Optimized Algorithm**

#### **Step 1: Convert Dates to Indices**
```java
int start = toIndex.apply(A[i]);  // "03-2021" → 1454
int end = toIndex.apply(B[i]);    // "03-2021" → 1454
```

#### **Step 2: Range Updates with Difference Array**
```java
// For each expense period [start, end] with cost C[i]:
diff[start] += C[i];      // Add cost at start
diff[end + 1] -= C[i];    // Subtract cost after end
```

**Test Case 1 Example:**
- Period 1: [1454, 1454], cost 20 → diff[1454] += 20, diff[1455] -= 20
- Period 2: [1455, 1456], cost 10 → diff[1455] += 10, diff[1457] -= 10  
- Period 3: [1456, 1456], cost 15 → diff[1456] += 15, diff[1457] -= 15

#### **Step 3: Convert to Actual Monthly Expenses**
```java
long runningExpense = 0;
for (int i = 0; i < size - 1; i++) {
    runningExpense += diff[i];  // Prefix sum = actual expense this month
    // Use runningExpense for calculations
}
```

**This gives us:**
- Month 1454: 20 (only Period 1)
- Month 1455: 10 (only Period 2)  
- Month 1456: 25 (Period 2 + Period 3)

#### **Step 4: Calculate Required Income**
```java
long prefixExpense = 0;
long maxIncome = 0;
int months = 0;

for (int i = 0; i < size - 1; i++) {
    runningExpense += diff[i];   // Expense this month
    prefixExpense += runningExpense;  // Cumulative expense
    months++;
    
    long needed = (prefixExpense + months - 1) / months;  // Ceiling
    maxIncome = Math.max(maxIncome, needed);
}
```

### **Why This is Optimized**

#### **Brute Force/Binary Search:**
```
for each month:                    // NumMonths
    for each expense:              // NumExpenses
        check if expense is active // O(1)
```
**Complexity**: O(NumMonths × NumExpenses)

#### **Optimized Solution:**
```
// One pass to build difference array
for each expense:                  // NumExpenses
    diff[start] += cost
    diff[end+1] -= cost

// One pass to calculate result  
for each month:                    // NumMonths
    runningExpense += diff[i]
    calculate needed
```
**Complexity**: O(NumMonths + NumExpenses)

### **Real-World Performance**

**For Large Input:**
- NumMonths = 2,400 (200 years)
- NumExpenses = 10,000

**Binary Search**: 20 × 2,400 × 10,000 = 480 million operations

**Optimized**: 2,400 + 10,000 = 12,400 operations

**Speedup**: 38,700x faster!

### **The Key Insight**
The optimized solution realizes that:
1. We don't need to test different incomes
2. We can directly calculate the minimum income needed
3. The answer is simply the **maximum ceiling of cumulative averages**

This eliminates the binary search entirely and gives us the optimal O(n + m) solution!

### **Why Binary Search is Better than Brute Force**

| Approach | Operations | Test Case 1 | Large Input |
|----------|------------|-------------|-------------|
| Brute Force | MaxIncome × NumMonths × NumExpenses | 405 | Very Slow |
| Binary Search | log(MaxIncome) × NumMonths × NumExpenses | 54 | Much Faster |
| Optimized | NumMonths + NumExpenses | 6 | Fastest |

### **Real-World Impact**

**For a large input:**
- MaxIncome = 1,000,000
- NumMonths = 2,400 (200 years)
- NumExpenses = 10,000

**Brute Force**: 1,000,000 × 2,400 × 10,000 = 24 trillion operations ❌

**Binary Search**: 20 × 2,400 × 10,000 = 480 million operations ✅

**Optimized**: 2,400 + 10,000 = 12,400 operations ⚡

### **Conclusion**
The double loop in `works()` gives us **O(NumMonths × NumExpenses)** complexity, which is acceptable when combined with binary search's **O(log(MaxIncome))** factor.

#### 6. **Check for Bankruptcy**
```java
if (balance < 0) return false;
```
- If balance ever goes negative, this income is insufficient
- Return false immediately (no need to continue)

#### 7. **Success**
```java
return true;
```
- If we complete all months without going negative
- This income works!

### Example Walkthrough (income = 20):

**Month 1454 (March):**
- balance = 0 + 20 = 20
- Check expenses: Only Period 0 active → balance = 20 - 20 = 0
- balance >= 0 ✅

**Month 1455 (April):**
- balance = 0 + 20 = 20
- Check expenses: Only Period 1 active → balance = 20 - 10 = 10
- balance >= 0 ✅

**Month 1456 (May):**
- balance = 10 + 20 = 30
- Check expenses: Period 1 + Period 2 active → balance = 30 - 10 - 15 = 5
- balance >= 0 ✅

**Result:** Never negative → return true ✅

### Key Insight
This function simulates real-world budgeting: add income, subtract expenses, check if you ever run out of money.

## Helper Functions

### findMinMonth - Where It Comes From
We need this to know **when to start** our simulation.

```java
private int findMinMonth(String[] A) {
    int min = Integer.MAX_VALUE;
    
    for (String date : A) {
        int monthIndex = getMonth(date);  // Convert "03-2021" → 1454
        min = Math.min(min, monthIndex);
    }
    
    return min;
}
```

**For Test Case 1:**
- A = ["03-2021", "04-2021", "05-2021"]
- Convert: 1454, 1455, 1456
- **minMonth = 1454** (March 2021)

### getMonth - Date Conversion
```java
private int getMonth(String date) {
    int month = Integer.parseInt(date.substring(0, 2));  // "03" → 3
    int year = Integer.parseInt(date.substring(3, 7));    // "2021" → 2021
    return (year - 1900) * 12 + (month - 1);              // Convert to index
}
```

**What These Built-in Functions Do:**

### Integer.parseInt()
- **Purpose**: Converts string to integer
- **Example**: `"03"` → `3`, `"2021"` → `2021`

### String.substring()
- **Purpose**: Extracts part of a string
- **Example**: `"03-2021".substring(0, 2)` → `"03"`
- **Example**: `"03-2021".substring(3, 7)` → `"2021"`

### Step-by-Step Breakdown:

**Input:** `"03-2021"`

1. **`date.substring(0, 2)`**
   - Takes characters from index 0 to 2 (not inclusive)
   - `"03-2021"` → `"03"`

2. **`Integer.parseInt("03")`**
   - Converts string `"03"` to integer `3`

3. **`date.substring(3, 7)`**
   - Takes characters from index 3 to 7 (not inclusive)
   - `"03-2021"` → `"2021"`

4. **`Integer.parseInt("2021")`**
   - Converts string `"2021"` to integer `2021`

5. **`(year - 1900) * 12 + (month - 1)`**
   - `(2021 - 1900) * 12 + (3 - 1)`
   - `121 * 12 + 2`
   - `1452 + 2 = 1454`

**Result:** `"03-2021"` → `1454`

### Why This Formula?
- **1900**: Base year (reference point)
- **12**: Months per year
- **(year - 1900) * 12**: Years converted to months since 1900
- **(month - 1)**: Months are 0-indexed (January = 0, March = 2)

### findMaxMonth (similar to findMinMonth)
```java
private int findMaxMonth(String[] B) {
    int max = Integer.MIN_VALUE;
    
    for (String date : B) {
        int monthIndex = getMonth(date);
        max = Math.max(max, monthIndex);
    }
    
    return max;
}
```

**For Test Case 1:**
- B = ["03-2021", "05-2021", "05-2021"]
- Convert: 1454, 1456, 1456
- **maxMonth = 1456** (May 2021)

## Why We Need Both
- **minMonth**: When expenses start (March 2021)
- **maxMonth**: When expenses end (May 2021)
- **Simulation range**: March 2021 → May 2021
```

## Time Complexity
- Binary search: O(log(MaxIncome))
- Each test: O(NumMonths × NumExpenses)
- Total: O(log(MaxIncome) × NumMonths × NumExpenses)

## Comparison with Brute Force
- **Brute Force**: O(MaxIncome × NumMonths × NumExpenses)
- **Binary Search**: O(log(MaxIncome) × NumMonths × NumExpenses)

**Much faster!** For MaxIncome = 45:
- Brute force: 45 tests
- Binary search: ~6 tests (log₂45)
