class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        long lo = (long)lower - 1;
        long up = (long)upper + 1;
        for(int i = 0; i <= nums.length; i++) {
            long next = i == nums.length ? up : nums[i];
            if(next - lo > 1) {
                res.add(createRange(next - 1, lo + 1));
            }
            lo = next;
        }
        return res;
    }

    public String createRange(long upper, long lower) {
        return upper == lower ? String.valueOf(lower) : (lower + "->" + upper);
    }
}


/**
Problem: https://leetcode.com/problems/missing-ranges/
Analysis:
this problem contains a corner case:
nums => []
so we need two helper bond => long lo = lower - 1   long up = upper + 1;
and for each element check if(next - lo > 1) and then create range between next - 1 , lo + 1
TimeComplexity: O(N)
SpaceComplexity: O(1)
tag: #array
**/
