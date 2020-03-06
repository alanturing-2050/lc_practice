class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //use sliding window
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++) {
            sum +=nums[right];
            while(sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

/**
Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
Analysis:
we can use sliding window keep a window and calculate the sum
while(sum >= target) move the left
TimeComplexity:O(N)
SpaceComplexity: O(1)
tag:#SlidingWindow
**/
