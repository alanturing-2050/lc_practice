class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(1, (a,b) -> {
            return b.getValue() == a.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue();
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            curr.setValue(curr.getValue() - 1);
            sb.append(curr.getKey());
            
            // if (pq.isEmpty() && curr.getValue() > 0) return "";
            
            if (!pq.isEmpty()) {
                Map.Entry<Character, Integer> next = pq.poll();
                next.setValue(next.getValue() - 1);
                sb.append(next.getKey());
                if (next.getValue() > 0) pq.add(next);
            } else {
                if (curr.getValue() > 0) return "";
            }
            
            if (curr.getValue() > 0) pq.add(curr);
        }
        
        return sb.toString();
    }
}

/**
https://leetcode.com/problems/reorganize-string/description/
Problem:
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Solution:
Straightworward solution using heap, the idea is that at every step we first pull the character with largest number of occurances. There is couple of other similar problems on LC

Time: O(nlog26) for heap rearrangement
Space O(26) ~ O(1)
*/
