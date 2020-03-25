/**
https://leetcode.com/problems/counting-bits/description/

DP appoach is required to be able to compute faster

Time; O(n) 
Spakce: O(n)
*/

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i - (i & -i)] + 1;
        }
        
        return res;
        
    }
}