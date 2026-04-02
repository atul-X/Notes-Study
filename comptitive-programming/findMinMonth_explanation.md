# findMinMonth Function - Where It Comes From

## Why We Need findMinMonth

When simulating the expenses over time, we need to know:
1. **When to start** our simulation (earliest expense)
2. **When to end** our simulation (latest expense)

## What findMinMonth Does
Finds the earliest month when any expense starts.

## How to Implement findMinMonth

### Input: Array A (start dates)
A = ["03-2021", "04-2021", "05-2021"]

### Step 1: Convert Each Date to Month Index
```java
private int getMonth(String date) {
    int month = Integer.parseInt(date.substring(0, 2));  // "03" → 3
    int year = Integer.parseInt(date.substring(3, 7));    // "2021" → 2021
    return (year - 1900) * 12 + (month - 1);              // Convert to index
}
```

### Step 2: Find Minimum
```java
private int findMinMonth(String[] A) {
    int min = Integer.MAX_VALUE;
    
    for (String date : A) {
        int monthIndex = getMonth(date);
        min = Math.min(min, monthIndex);
    }
    
    return min;
}
```

## Example with Test Case 1

### Input:
A = ["03-2021", "04-2021", "05-2021"]

### Convert to Month Indices:
- "03-2021" → (2021-1900)*12 + (3-1) = 1454
- "04-2021" → (2021-1900)*12 + (4-1) = 1455  
- "05-2021" → (2021-1900)*12 + (5-1) = 1456

### Find Minimum:
min = min(1454, 1455, 1456) = **1454**

## Why We Need This

### Without findMinMonth:
```java
// When do we start our simulation?
for (int month = ???; month <= maxMonth; month++) {  // What's the start?
    // simulate expenses
}
```

### With findMinMonth:
```java
int minMonth = findMinMonth(A);  // 1454 (March 2021)
int maxMonth = findMaxMonth(B);  // 1456 (May 2021)

for (int month = minMonth; month <= maxMonth; month++) {
    // Simulate from March to May 2021
}
```

## Complete Picture

### We Need Both:
- **findMinMonth(A)**: When expenses start
- **findMaxMonth(B)**: When expenses end

### For Test Case 1:
- **minMonth = 1454** (March 2021)
- **maxMonth = 1456** (May 2021)
- **Simulation range**: March 2021 → May 2021

## In the Original Solution
This is exactly what lines 19-27 do:

```java
int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;

for (int i = 0; i < n; i++) {
    start[i] = toIndex.apply(A[i]);  // Convert to month index
    end[i]   = toIndex.apply(B[i]);
    minIdx = Math.min(minIdx, start[i]);  // This is findMinMonth!
    maxIdx = Math.max(maxIdx, end[i]);    // This is findMaxMonth!
}
```

So **findMinMonth** is just finding the earliest start date from array A.
