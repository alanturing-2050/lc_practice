class Solution {
    public int longestPalindrome(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        for(char c : s.toCharArray()) {
            if(c >= 97) lowercase[c - 'a']++;
            else uppercase[c - 'A']++;
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            res += (lowercase[i] / 2) * 2;
            res += (uppercase[i] / 2) * 2;
        }
        return res == s.length() ? res : res + 1;
    }
}

/**
problem: https://leetcode.com/problems/longest-palindrome/
use two int array represent lowercase and uppercase count
res += (count / 2 ) * 2
if res is equals to s length means all are even count else res = res + 1 (at least one odd count)
TimeComplexity: O(N)
SpaceComplexity: O(26 * 2)
**/
