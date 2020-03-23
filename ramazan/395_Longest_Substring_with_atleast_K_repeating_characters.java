/**
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

I used recursive approach to solve the problem. First we check if the string we have is valid, otherwise
check substring the same way.

Time : ~O(n^3)
Space: O(n)

*/

class Solution {
    public int longestSubstring(String s, int k) {
        int[] letters = new int[26];
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            letters[idx]++;
        }
        
        boolean aboveK = true;
        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0 && letters[i] < k) aboveK = false;
        }
        
        if (aboveK) return s.length();
        
        int max = 0;
        int currStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longestSubstring(s.substring(currStart, i), k));
                currStart = i+1;
            }
        }
        max = Math.max(max, longestSubstring(s.substring(currStart), k));
        
        return max;
    }
}