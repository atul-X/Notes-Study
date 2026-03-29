**Let's make this concrete. Every DP problem fits one of these 5 patterns:**

| Pattern     | Key signal in the problem     | Example            |
| ----------- | ----------------------------- | ------------------ |
| Linear      | "how many ways" on a sequence | Climbing stairs    |
| Knapsack    | "pick items, max/min value"   | Coin change        |
| Subsequence | two sequences being compared  | LCS, Edit distance |
| Interval    | "range [i,j]" in the problem  | Burst balloons     |
| Tree        | tree structure given          | House robber III   |
Let's do a quick rapid fire to lock this in. Just tell me the pattern — one word answer each time:

**Q1:** Given a string, find if it can be segmented into dictionary words.-> 

**Q2:** Given two strings, find the longest common substring.

**Q3:** Given weights and values of items and a bag capacity, maximize the value.

**Q4:** Given a matrix, find the minimum path sum from top-left to bottom-right.