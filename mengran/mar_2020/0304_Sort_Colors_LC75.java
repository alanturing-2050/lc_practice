class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while(mid <= right) {
            if(nums[mid] == 0) {
               swap(nums, left, mid);
                left++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else if(nums[mid] == 2) {
                swap(nums, mid, right);
                right--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
Problem: https://leetcode.com/problems/sort-colors/
Analysis:
use three pointers: left mid right
if(nums[mid] == 0) need to swap left and mid and increase both
else if(nums[mid] == 1) just increase mid
else swap(mid, right) right--;
TimeComplexity: O(n)
SpaceComplexity: O(1)
tag: #sort #Array

**/
