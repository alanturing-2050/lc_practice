class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}


/**
Problem:
https://leetcode.com/problems/subarray-sum-equals-k/description/

Statement:
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

The approach to solve this problem is similar to 523. 
We calculate cumulative sum and store it in a HashMap. Then every step chec if there is an element "sum - k" in that map.
We also need to keep track how many times certain sum was seen and increment it.

Time: O(n)
Space: O(n)

*/