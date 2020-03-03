class Solution {
    public int minCostII(int[][] costs) {
       //sanity check
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        if(k == 1) return n == 1 ? costs[0][0] : -1;
        int preMin = 0;
        int preSecondMin = 0;
        int preIndex = -1;
        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int secMin = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j < k; j++) {
                int val = costs[i][j] + (preIndex == j ? preSecondMin : preMin);
                if(index < 0) {
                    min = val;
                    index = j;
                }
                else if(val < min) {
                secMin = min;
                min = val;
                index = j;
                }
                else if(val < secMin) {
                    secMin = val;
                }
            }
            preMin = min;
            preSecondMin = secMin;
            preIndex = index;
        }
        return preMin;
    }
}

/**
Problem: https://leetcode.com/problems/paint-house-ii/
Analysis:
this problem can be solved by DP
dp[i][j] represent the min cost for i row using j color, dp[i][j] = min(any k != j dp[i - 1][k] + costs[i][j])
so we can just store the previous minimum and the index, and also the secMin which is not use the index
we keep updating the preMin and second Min and the index


TimeComplexity: O(NK)
SpaceComplexity O(1)

tag: #Dynamic programming
**/
