class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remSeen = new HashMap<>();
        remSeen.put(0, -1);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            
            Integer prev = remSeen.get(sum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else {
                remSeen.put(sum, i);
            }
        }
        
        return false;
    }
}

/**
Problem statement:
Given a list of non-negative numbers and a target integer k, 
write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, 
that is, sums up to n*k where n is also an integer.
*/


/**
https://leetcode.com/problems/continuous-subarray-sum/description/

Analysis:
I got similar question was asked at Facebook.
Thres is a bruteforce solution that has complexity O(n^2). But it's not a proper solution.

The idea behind this solution is to use module and keep updating it as we move through the array. 
Let's imaging that there are sequence of elements:
    a1 + a2 + a3  and K is the 

If modulo of a1 % K == X and module of (a1 + a2 + a3) % K == X as well it, it means that (a2 + a3) % K == 0 -> so a2 + a3 is divisible by K.
To find the there were any elements whose module summed up to X we keep track of those elements in a HashMap. There are couple of tricks used though:

    1. To deal with cases when k == 0, we make sure not to divide the cumulative modulo sum.
    2. To deal with cases when there are arrays where all alements are 0 or 0 module we add a dummy element to map at position -1:
            remSeen.put(0, -1);
    3. Only add elements if there were no cumulative sum of the same value seen before
    4. make sure that previous remainder is at least 2 positions away: 
            if (i - prev > 1)


    Time complexity : O(n)
    Space complexity: O(min(n, k)) since we can have keys only up to K in our map
    