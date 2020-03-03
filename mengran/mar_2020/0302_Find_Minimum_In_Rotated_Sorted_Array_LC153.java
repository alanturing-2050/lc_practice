class Solution {
    public int findMin(int[] nums) {
        // use binary search, two conditions: if not the swap part it should be nums[0], if swap it should be less than previous
        int left = 0;
        int right = nums.length - 1;
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            else if(nums[mid] < nums[right]) right = mid;
            else left = mid;
        }
        return Math.min(nums[left], nums[right]);
    }
}

/**
Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Analysis:
suppose if no rotation it should be nums[0]
if swap the minimum shoud be smaller than the previous one
so we can use binary search
if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid]
if(nums[mid] < nums[right]) right = mid;
else left = mid;
TimeComplexity: O(log(n))
SpaceComplexity: O(1)

tag:#Binary search
**/
