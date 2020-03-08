class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        
        int sum = 0;
        for (int val : nums) sum+=val;
        if (sum % 2 == 1) return false;
        
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int i = sum/2; i >= 0; i--) {
                if (i >= num) {
                    dp[i] |= dp[i - num]; 
                }
            }
        }
        
        return dp[sum/2];
    }
}


/**
https://leetcode.com/problems/partition-equal-subset-sum/description/

Classical 0/1 Bounded Knapsack problem

Time: O(n * sum/2)
Space O(sum/2)
*/