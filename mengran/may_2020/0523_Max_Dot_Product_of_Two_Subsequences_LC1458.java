class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        long res = Integer.MIN_VALUE;
        long[][] dpMax = new long[length1 + 1][length2 + 1];
        for(int i = 0; i < dpMax.length; i++) {
            for(int j = 0; j < dpMax[0].length; j++) {
                dpMax[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                long cur = Math.max(0, dpMax[i][j]) + nums1[i]*nums2[j];
                dpMax[i + 1][j + 1] = Math.max(dpMax[i+ 1][j], Math.max(cur, dpMax[i][j + 1]));
            }
        }
        return (int)dpMax[length1][length2];
    }
}

/**
https://leetcode.com/problems/max-dot-product-of-two-subsequences/
Analysis:
this problem can be solved by DP
dp[i + 1][j + 1] represent the max doc product from nums1[0 to ith element] and nums2[0...jth element]
dp[i + 1][j + 1] = if take nums1[i] and nums2[j] max(nums1[i] * nums2[j], dp[i][j] + nums1[i] * nums2[j]) or if not take nums1[i] dp[i][j + 1] or if not take nums2[j] dp[i + 1][j]
TimeComplexity: O(NM)
SpaceComplexity O(NM)
tag: #Dynamic programming
**/
