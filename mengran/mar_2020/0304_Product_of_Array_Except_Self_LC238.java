class Solution {
    public int[] productExceptSelf(int[] nums) {
        //two pass for the array from left to right and right to left
        //sanity check
        if(nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        // calculate the left product
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i]  = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        // then calculate its right part
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        return res;
    }
}

/**
Problem: https://leetcode.com/problems/product-of-array-except-self/
Analysis:
two pass, from left to right calculate the left product and store it, then from right to left add right calculate part
TimeComplexity:O(N)
SpaceComplexity: O(N)

tag:#Array
**/
