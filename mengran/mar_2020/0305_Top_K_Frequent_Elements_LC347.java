class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //use bucket sort
        List<Integer> res = new ArrayList();
        if(nums == null || nums.length == 0 || k <= 0) return res;
        Map<Integer, Integer> freq = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int count = freq.getOrDefault(nums[i], 0);
            freq.put(nums[i], count + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        for(int pos = nums.length; pos >= 0 && res.size() < k; pos--) {
            if(bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
/**
Problem: https://leetcode.com/problems/top-k-frequent-elements/
Analysis:
can use bucket sort frequence range should be 1 ~ nums.length
TimeComplexity: O(N)
SpaceComplexity: O(N)
tag:#BucketSort
