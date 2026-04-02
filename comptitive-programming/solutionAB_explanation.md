# SolutionAB Problem Explanation

## Problem Statement
Given points with tags, find the maximum number of points that can be placed on a map without any conflicts.

### **Input:**
- **S**: String of tags (e.g., "ABDCA")
- **X**: X-coordinates of points
- **Y**: Y-coordinates of points

### **Output:**
Maximum number of points that can be placed without conflicts.

## What is a "Conflict"?

### **Rule 1: Same Distance, Same Tag**
If two points have the **same distance from origin** AND the **same tag**, they conflict.

### **Rule 2: Same Tag at Different Distances**
If a tag appears at one distance, it cannot appear at any other distance.

## Algorithm Breakdown

### **Step 1: Calculate Distances**
Convert each point to distance from origin:
```
distance² = x² + y²
```

**Test Case 1:**
- A(2,2): 2² + 2² = 8
- B(-1,-2): (-1)² + (-2)² = 5
- D(-4,4): (-4)² + 4² = 32
- C(-3,1): (-3)² + 1² = 10
- A(3,-3): 3² + (-3)² = 18

### **Step 2: Sort by Distance**
Sort points by their distance from origin:
```
Distance 5:  B
Distance 8:  A
Distance 10: C
Distance 18: A
Distance 32: D
```

### **Step 3: Process Distance Groups**
Process each distance group in order:

#### **Distance 5:**
- Points: {B}
- No conflicts within group
- B not used before
- **Include B** → count = 1

#### **Distance 8:**
- Points: {A}
- No conflicts within group
- A not used before
- **Include A** → count = 2

#### **Distance 10:**
- Points: {C}
- No conflicts within group
- C not used before
- **Include C** → count = 3

#### **Distance 18:**
- Points: {A}
- No conflicts within group
- **But A already used at distance 8!**
- **Conflict!** → stop, return count = 3

#### **Distance 32:**
- Never reached because we stopped at distance 18

## Why This Algorithm Works

### **Key Insight:**
Once we find a conflict, we cannot include any points at larger distances because:
- The conflict occurs at distance D
- All remaining points are at distance > D
- If we can't resolve conflict at D, we can't proceed further

### **Conflict Detection:**
1. **Within same distance**: Check for duplicate tags
2. **Across distances**: Check if tag was used before

## Step-by-Step Code Analysis

### **Distance Calculation**
```java
long d2 = 1L * X[i] * X[i] + 1L * Y[i] * Y[i];
```
- Uses long to prevent overflow
- Calculates squared distance (no need for sqrt)

### **Sorting**
```java
points.sort(Comparator.comparingLong(p -> p.dist2));
```
- Sort by distance from origin (closest to farthest)

### **Group Processing**
```java
while (j < n && points.get(j).dist2 == d) {
    char tag = points.get(j).tag;
    if (group.contains(tag)) return count;  // Same distance conflict
    group.add(tag);
    j++;
}
```
- Collect all points at same distance
- Check for duplicate tags within group

### **Cross-Distance Conflict Check**
```java
for (char tag : group) {
    if (used.contains(tag)) return count;  // Different distance conflict
}
```
- Check if any tag in this group was used before

### **Safe Inclusion**
```java
used.addAll(group);
count += group.size();
```
- If no conflicts, add all tags to used set
- Increase count by number of points in this group

## Test Case Analysis

### **Test Case 1: "ABDCA"**
- **Result**: 3 (B, A at distance 8, C)
- **Conflict**: A appears at both distance 8 and 18

### **Test Case 2: "ABB"**
- Points: A(1,1), B(-2,-2), B(-2,2)
- Distances: A=2, B=8, B=8
- **Conflict**: Two B's at same distance
- **Result**: 1 (only A)

### **Test Case 3: "ABCDEF"**
- All points at different distances
- No conflicts
- **Result**: 6 (all points)

### **Test Case 4: "AABC"**
- Points: A(1,1), A(10,10), B(2,2), C(3,3)
- Distances: A=2, A=200, B=8, C=18
- **Conflict**: A appears at distances 2 and 200
- **Result**: 3 (A at distance 2, B, C)

## Time Complexity
- **Distance calculation**: O(n)
- **Sorting**: O(n log n)
- **Group processing**: O(n)
- **Total**: O(n log n)

## Space Complexity
- **Points list**: O(n)
- **Hash sets**: O(n) in worst case
- **Total**: O(n)

## Key Takeaways
1. **Sort by distance** to process from closest to farthest
2. **Group by distance** to handle same-distance conflicts
3. **Track used tags** to handle cross-distance conflicts
4. **Stop early** when first conflict is found
