# Interview Question: Algorithm Design & Optimization

## Problem Statement

You are given two different algorithmic challenges. Choose **one** to solve based on your confidence level, but be prepared to discuss both approaches.

---

## Option A: Financial Planning with Monthly Expenses (Medium-Hard)

### Context
A financial advisor needs to determine the minimum constant monthly income required to cover variable monthly expenses over time. Each expense has a start and end month with a fixed cost.

### Input
- `String[] A`: Start dates in format "MM-YYYY" (e.g., "03-2021")
- `String[] B`: End dates in format "MM-YYYY" (inclusive)
- `int[] C`: Monthly costs for each expense

### Output
Return the minimum constant monthly income needed to cover all expenses without going into debt.

### Example
```
Input:
A = ["03-2021", "04-2021", "05-2021"]
B = ["03-2021", "05-2021", "05-2021"] 
C = [20, 10, 15]

Output: 20
```

### Constraints
- 1 ≤ N ≤ 100,000
- Years: 1900-2100
- Costs: 1 ≤ C[i] ≤ 10,000

### Follow-up Questions
1. How would you solve this with O(N²) brute force?
2. Can you optimize to O(N log N) using prefix sums?
3. Can you achieve O(N) using difference arrays?
4. What if we used binary search on the answer? How would that work?

---

## Option B: GPS Tag Collection System (Medium)

### Context
A GPS system collects location points, each tagged with a letter. Points at the same distance from origin are collected simultaneously. If the same tag appears at the same distance, or a tag was used at a closer distance, the system stops.

### Input
- `String S`: Tags for each point (length N)
- `int[] X`: X coordinates
- `int[] Y`: Y coordinates

### Output
Return the maximum number of points that can be collected.

### Example
```
Input:
S = "ABDCA"
X = [2, -1, -4, -3, 3]
Y = [2, -2, 4, 1, -3]

Output: 3
```

### Constraints
- 1 ≤ N ≤ 100,000
- Coordinates: -1,000,000 ≤ X[i], Y[i] ≤ 1,000,000
- Tags: Uppercase letters A-Z

### Follow-up Questions
1. Why do we sort by distance squared instead of distance?
2. How do we handle points at the same distance?
3. What's the time complexity and why?
4. Can you solve this without sorting? What would be the trade-off?

---

## Interview Discussion Points

### For Option A:
- **Data Structures**: Difference arrays, prefix sums
- **Algorithms**: Range updates, binary search
- **Time Complexity**: O(N) vs O(N log N) approaches
- **Space Complexity**: O(M) where M = number of months

### For Option B:
- **Data Structures**: Sorting, sets, custom objects
- **Algorithms**: Greedy approach, grouping by distance
- **Time Complexity**: O(N log N) due to sorting
- **Space Complexity**: O(N)

## Evaluation Criteria

1. **Problem Understanding** (25%)
   - Can you explain the problem clearly?
   - Do you identify edge cases?

2. **Algorithm Design** (35%)
   - Do you choose an appropriate approach?
   - Can you justify your time/space complexity?

3. **Implementation** (25%)
   - Is your code clean and correct?
   - Do you handle edge cases properly?

4. **Optimization & Discussion** (15%)
   - Can you discuss alternative approaches?
   - Do you understand trade-offs?

## Expected Solution Time
- **Option A**: 25-30 minutes
- **Option B**: 20-25 minutes

## Bonus Questions
1. How would you modify Option A to handle variable income instead of constant income?
2. How would you optimize Option B if coordinates were guaranteed to be small integers?
3. Can you design a solution for Option A that works with streaming input (no random access)?

---

Choose one problem to solve, but be prepared to discuss the high-level approach for both. The interviewer will assess your problem-solving process, not just the final answer.
