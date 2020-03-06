class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        if (n == 0) return 0;
        
        int sign = 1;
        long num = 0;
        int idx = 0;
        while (idx < n && str.charAt(idx) == ' ') idx++;
        if (idx < n && (str.charAt(idx) == '-' || str.charAt(idx) == '+')) {
            sign = str.charAt(idx++) == '-' ? -1 : 1;
        }
        
        while(idx < n && num <= Integer.MAX_VALUE && Character.isDigit(str.charAt(idx))) {
            num = num * 10 + (str.charAt(idx++) - '0');
        }
        
        num *= sign;
        return (int)Math.min(Math.max(num, Integer.MIN_VALUE), Integer.MAX_VALUE);
        
    }
}

/**
https://leetcode.com/problems/string-to-integer-atoi/description/

Very straightforward solution but with couple of edge cases

Time: O(n)
Space: O(1)

*/