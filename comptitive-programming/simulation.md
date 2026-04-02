# Test Case 1 Simulation

## Input:
- A = ["03-2021", "04-2021", "05-2021"]
- B = ["03-2021", "05-2021", "05-2021"]  
- C = [20, 10, 15]

## Step 1: Date Conversion
BASE_YEAR = 1900

Convert "MM-YYYY" → month index:
- "03-2021": (2021-1900)*12 + (3-1) = 121*12 + 2 = 1452 + 2 = 1454
- "04-2021": (2021-1900)*12 + (4-1) = 121*12 + 3 = 1452 + 3 = 1455
- "05-2021": (2021-1900)*12 + (5-1) = 121*12 + 4 = 1452 + 4 = 1456

start[] = [1454, 1455, 1456]
end[] = [1454, 1456, 1456]

minIdx = 1454, maxIdx = 1456

## Step 2: Difference Array Setup
size = maxIdx - minIdx + 2 = 1456 - 1454 + 2 = 4
diff = [0, 0, 0, 0]  // indices 0,1,2,3

## Step 3: Range Updates
For each expense period:

**Period 1:** start=1454, end=1454, cost=20
- s = 1454-1454 = 0, e = 1454-1454 = 0
- diff[0] += 20 → [20, 0, 0, 0]
- diff[0+1] -= 20 → [20, -20, 0, 0]

**Period 2:** start=1455, end=1456, cost=10  
- s = 1455-1454 = 1, e = 1456-1454 = 2
- diff[1] += 10 → [20, -10, 0, 0]
- diff[2+1] -= 10 → [20, -10, -10, 0]

**Period 3:** start=1456, end=1456, cost=15
- s = 1456-1454 = 2, e = 1456-1454 = 2  
- diff[2] += 15 → [20, -10, 5, 0]
- diff[2+1] -= 15 → [20, -10, 5, -15]

Final diff = [20, -10, 5, -15]

## Step 4: Monthly Calculation
Iterate i = 0 to size-2 (0 to 2):

**Month 0 (March 2021):**
- runningExpense += diff[0] = 0 + 20 = 20
- prefixExpense += runningExpense = 0 + 20 = 20  
- months = 1
- needed = ceil(20/1) = 20

**Month 1 (April 2021):**
- runningExpense += diff[1] = 20 + (-10) = 10
- prefixExpense += runningExpense = 20 + 10 = 30
- months = 2
- needed = ceil(30/2) = 15

**Month 2 (May 2021):**
- runningExpense += diff[2] = 10 + 5 = 15
- prefixExpense += runningExpense = 30 + 15 = 45
- months = 3
- needed = ceil(45/3) = 15

## Verification:
- Month 1: Need 20 (expenses: 20)
- Month 2: Need 15 (expenses: 20+10=30, avg=15) 
- Month 3: Need 15 (expenses: 20+10+15=45, avg=15)

Maximum needed income = 20
