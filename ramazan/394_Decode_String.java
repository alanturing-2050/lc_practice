/**
https://leetcode.com/problems/decode-string/description/

solution is pretty straighforward but has a lot fo edge cases. Should be solved recursively.
(There are some cleaner implementations on LC)

Time: O(n)
Space: O(n) (for stringbuilder)

*/

class Solution {
    int i = 0;s
    public String decodeString(String s) {
        return decode(s, 1);
    }
    
    String decode(String s, int count) {
        int n = s.length();
        
        StringBuilder sb = new StringBuilder();
        while (i < n && s.charAt(i) != ']') {
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)) {
                int c = 0;
                while(Character.isDigit(s.charAt(i))) {
                    c = c * 10 + s.charAt(i++) - '0';
                }
                i++;
                sb.append(decode(s, c));             
            } else {
                sb.append(curr);
                i++;
            }
        }

        i++;
        
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < count; k++) {
            res.append(sb.toString());
        }
        
        return res.toString();
    }
}