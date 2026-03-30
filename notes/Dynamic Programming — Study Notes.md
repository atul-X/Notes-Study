

## The 3-Question Framework (Run BEFORE every problem)

Always answer these 3 questions in plain English before writing any code:

1. **Is this DP? What is the choice at each step?**
2. **What does `dp[i]` mean in one precise sentence?**
3. **What are the base cases?**

> Rule: No formula = no keyboard. No `dp[i]` definition = no keyboard.

---

## The 5 DP Patterns + Signal Words

|Pattern|Signal Words|Example Problems|
|---|---|---|
|Linear|"ways to climb / decode / jump", "subarray", "grid / matrix / path"|Climbing Stairs, Max Subarray, Jump Game|
|Knapsack|"coins + target", "max value", "capacity / budget", "pick items"|Coin Change, 0/1 Knapsack, Word Break|
|Subsequence|"two strings", "convert one into another", "subsequence"|LCS, Edit Distance, Decode Ways|
|Interval|"range [i,j]", "burst", "matrix chain"|Burst Balloons, Palindrome Partitioning II|
|Tree|"tree / root / node"|House Robber III, Unique BSTs|

> Key distinction:
> 
> - **subarray** = contiguous = Linear DP
> - **subsequence** = not necessarily contiguous = Subsequence DP
> - **Knapsack** = one array + a target/capacity constraint
> - **Linear** = one array, no constraint, just move forward

---

## Why Recursion?

A function solves a big problem by **trusting** it can solve a smaller version of the same problem.

**Overlapping subproblems** = the same subproblem is solved **multiple times** across different branches of the recursion tree. This is what makes memoization valuable.

```
fib(5)
├── fib(4)
│   ├── fib(3)
│   │   ├── fib(2)  ← computed here
│   │   └── fib(1)
│   └── fib(2)      ← computed again
└── fib(3)
    ├── fib(2)      ← computed again
    └── fib(1)
```

`fib(2)` computed 3 times → wasteful → fix with memoization.

---

## Memoization Template (Top-Down)

```java
int[] dp = new int[n + 1];
Arrays.fill(dp, -1);

int fn(int[] nums, int idx) {
    // 1. Base cases first
    if (idx == ...) return ...;

    // 2. Cache check
    if (dp[idx] != -1) return dp[idx];

    // 3. Compute
    int result = ...;

    // 4. Store + return
    dp[idx] = result;
    return result;
}
```

> Order always: base cases → cache check → compute → store → return

> For boolean memoization use `Boolean[]` (object, can be null) not `boolean[]` (primitive, defaults to false — can't detect "not computed").

---

## Problems Solved

### Climbing Stairs (LC 70) — Linear DP

**Pattern:** Linear

**dp[i]:** number of distinct ways to reach step `i` from step `0`

**Recurrence:** `dp[i] = dp[i-1] + dp[i-2]`

**Base cases:**

- `dp[1] = 1`
- `dp[2] = 2`

**Key insight:** At the bottom you have 2 choices — take 1 step or take 2 steps. Each choice leaves a smaller version of the same problem. This is Fibonacci in disguise.

```java
int[] dp = new int[n + 1];
Arrays.fill(dp, -1);

int fn(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (dp[n] != -1) return dp[n];
    dp[n] = fn(n - 1) + fn(n - 2);
    return dp[n];
}
```

---

### Decode Ways (LC 91) — Subsequence / Linear DP

**Pattern:** Linear (single string, moving forward)

**dp[i]:** number of ways to decode the string from index `i` to the end

**Choices at each index:**

- Take 1 digit → valid if `s.charAt(i) != '0'`
- Take 2 digits → valid if `twoDigit >= 10 && twoDigit <= 26`

**Base cases:**

- `i >= s.length()` → return `1` (found one valid decoding)
- `s.charAt(i) == '0'` → return `0` (dead end, can't decode '0' alone)

```java
Boolean[] dp = new Boolean[s.length()];

int fn(String s, int i) {
    if (i >= s.length()) return 1;
    if (s.charAt(i) == '0') return 0;
    if (dp[i] != null) return dp[i];

    int takeOne = fn(s, i + 1);
    int takeTwo = 0;
    if (i + 1 < s.length()) {
        int twoDigit = Integer.parseInt(s.substring(i, i + 2));
        if (twoDigit >= 10 && twoDigit <= 26) {
            takeTwo = fn(s, i + 2);
        }
    }

    dp[i] = takeOne + takeTwo;
    return dp[i];
}
```

> Why `>= 10` and not `> 10`? Because "10" maps to J — valid. "06" has a leading zero — invalid. Range is 10–26 inclusive.

---

### Jump Game II (LC 45) — Linear DP

**Pattern:** Linear

**dp[i]:** minimum number of jumps to reach index `i` from index `0`

**Choice at each index:** jump 1 to `nums[i]` steps forward

**Base cases:**

- `idx == nums.length - 1` → return `0` (already at end)
- `idx > nums.length - 1` → return `Integer.MAX_VALUE` (overshot, invalid path)

**Key insight:** `result + 1` = 1 jump to get here + result jumps from here to end

```java
int[] dp = new int[nums.length];
Arrays.fill(dp, -1);

int fn(int[] nums, int idx) {
    if (idx == nums.length - 1) return 0;
    if (idx > nums.length - 1) return Integer.MAX_VALUE;
    if (dp[idx] != -1) return dp[idx];

    int minJumps = Integer.MAX_VALUE;
    for (int jump = 1; jump <= nums[idx]; jump++) {
        int result = fn(nums, idx + jump);
        if (result != Integer.MAX_VALUE) {
            minJumps = Math.min(minJumps, result + 1);
        }
    }

    dp[idx] = minJumps;
    return minJumps;
}
```

> Why check `result != Integer.MAX_VALUE` before adding 1? To avoid integer overflow — `MAX_VALUE + 1` wraps to a negative number.

---

### Jump Game I (LC 55) — Linear DP

**Pattern:** Linear

**dp[i]:** can I reach the last index from index `i`? → true or false

**Choice at each index:** jump 1 to `nums[i]` steps forward

**Base cases:**

- `idx >= nums.length - 1` → return `true` (reached or passed end)
- `nums[idx] == 0` and not at end → return `false` (stuck, can't move)

```java
Boolean[] dp = new Boolean[nums.length];

boolean fn(int[] nums, int idx) {
    if (idx >= nums.length - 1) return true;
    if (nums[idx] == 0) return false;
    if (dp[idx] != null) return dp[idx];

    for (int jump = 1; jump <= nums[idx]; jump++) {
        if (fn(nums, idx + jump)) {
            dp[idx] = true;
            return true;
        }
    }

    dp[idx] = false;
    return false;
}
```

> Loop starts at `jump = 1` not `jump = 0` — jumping 0 steps means staying in place forever (infinite loop).

---

## Common Mistakes to Avoid

|Mistake|Fix|
|---|---|
|Coding before defining `dp[i]`|Always write the definition first in plain English|
|Using `boolean[]` for memoization|Use `Boolean[]` — null means "not computed"|
|Loop starting at `i = idx`|Loop jump size from `1` to `nums[idx]`|
|`Integer.MAX_VALUE + 1` overflow|Check `result != Integer.MAX_VALUE` before adding|
|`i > s.length()` off by one|Use `i >= s.length()`|
|Forgetting boundary check on substring|Check `i+1 < s.length()` before `substring(i, i+2)`|
|Comparing char to int: `charAt(i) == 0`|Compare to char: `charAt(i) == '0'`|

---

## Interview Freeze? Run This Checklist

```
1. Read the problem → spot the signal word → identify pattern
2. What is the choice at each step?
3. Define dp[i] in one sentence
4. Write base cases
5. Write recurrence as a formula
6. Only now write code
7. Trace through a small example to verify
```

> If you freeze → go back to step 1. The checklist always unsticks you.