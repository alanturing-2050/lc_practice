class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j =0; j < B.length; j++) {
                int sum = A[i] + B[j];
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (int i = 0; i < C.length; i++) {
            for (int j =0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (sumCount.containsKey(0 - sum)) {
                    count += sumCount.get(0 - sum);
                }
            }
        }
        
        return count;
    }


/**
https://leetcode.com/problems/4sum-ii/description/

Can be solved using 2 loops and Map to store intermediate sums for fist 2 elements

Time: O(n^2)
Space: O(n^2)
*/