**Let's make this concrete. Every DP problem fits one of these 5 patterns:**

| Pattern     | Key signal in the problem     | Example            |
| ----------- | ----------------------------- | ------------------ |
| Linear      | "how many ways" on a sequence | Climbing stairs    |
| Knapsack    | "pick items, max/min value"   | Coin change        |
| Subsequence | two sequences being compared  | LCS, Edit distance |
| Interval    | "range [i,j]" in the problem  | Burst balloons     |
| Tree        | tree structure given          | House robber III   |
Let's do a quick rapid fire to lock this in. Just tell me the pattern — one word answer each time:

**Q1:** Given a string, find if it can be segmented into dictionary words.-> Knapsack

**Q2:** Given two strings, find the longest common substring.->Subsequence

**Q3:** Given weights and values of items and a bag capacity, maximize the value.->Knapsack

**Q4:** Given a matrix, find the minimum path sum from top-left to bottom-right.->Knapsack


**Problem: Jump Game II (LC 45)**

> Given an array of integers `nums`, where `nums[i]` represents the maximum number of steps you can jump from index `i`, find the **minimum number of jumps** to reach the last index.
> 
> Example:
> 
> ```
> nums = [2, 3, 1, 1, 4]
> output = 2
> explanation: jump from index 0→1, then 1→4
> ```

---

**Your 3 questions. No code. Just thinking:**

**Q1.** Is this recursion/DP? What's the choice at each index?
	minimum step required to reach any index. take this or not;

**Q2.** Define `dp[i]` in one precise sentence. What does it represent?
		dp[i] mean step required at ith index.
**Q3.** What are the base cases?
		if idx> n ==0



int fn(int[] arr,int idx){
	if(idx==arr.lenghth){
	
	}
	 
	 int nextIndex=arr[idx];
	 for(int i=idx;i<nextIndex;i++){
		 step=fn(arr,idx+i);
	 }
}