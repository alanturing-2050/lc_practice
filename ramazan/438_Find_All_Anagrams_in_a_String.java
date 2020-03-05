class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for (char ch : p.toCharArray()) pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);

        int count = pMap.size();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (pMap.containsKey(curr)) {
                pMap.put(curr, pMap.get(curr) - 1);
                if (pMap.get(curr) == 0) count--;
            }
            
            if (i - l >= p.length()) {
                char toRem = s.charAt(l);
                if (pMap.containsKey(toRem)) {
                    pMap.put(toRem, pMap.get(toRem) + 1);
                    if (pMap.get(toRem) > 0) count++;
                }
                
                l++;
            }
            
            if (count == 0) res.add(l);
        }
        
        return res;
    }
}

/**
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Problem statement:
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Solution:
Sliding window solution. There are couple of similar problems on LC.

Time: O(n)
Space: O(n)

*/