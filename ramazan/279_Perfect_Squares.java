/**
https://leetcode.com/problems/perfect-squares/description/
	
	dfs + memoization solution. bottom up apprach also feasable but looks a little hard to read

	Time: O(n)
	Space O(n)
*/


class Solution {
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        
        return count(n, dp);
    }
    
    int count(int n, Integer[] dp) {
        if (n == 0) return 0;
        
        if (dp[n] != null) return dp[n];
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, count(n - i * i, dp) + 1);
        }
        
        dp[n] = min;
        
        return min;
    }
}