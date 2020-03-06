class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       // solve it in dynamic programming
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <=s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                }
            }
        }
        return dp[s.length()];
    }
}

/**
Problem: https://leetcode.com/problems/word-break/
Analysis: very classic dp problem, use dp table to record the status
TimeComplexity: O(N^2)
SpaceComplexity: O(N)
tag:#DP
**/
