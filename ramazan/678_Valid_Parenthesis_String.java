class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0, idx = 0;
        
        return check(s, idx, l, r);
    }
    
    private boolean check(String s, int idx, int l, int r) {
        if (idx == s.length()) return l == r;
        if (r > l) return false;
        
        char curr = s.charAt(idx);
        
        if (curr == '(') {
            return check(s, idx+1, l+1, r);
        } else if (curr == ')') {
            return check(s, idx+1, l, r+1);
        } else {
            return check(s, idx+1, l, r) || check(s, idx + 1, l+1, r) || check(s, idx+1, l, r+1);
        }
    }
}

// Optimal

class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char ch : s.toCharArray()) {
            lo += ch == '(' ? 1 : -1;
            hi += ch == ')' ? 1 : -1;
            
            if (hi > 0) return false;
            lo = Math.max(0, lo);
        }
        
        return lo == 0;
    }
}


/**
https://leetcode.com/problems/valid-parenthesis-string/description/

In the greedy solution lo is min possible left paranthesis, and hi is min right paranthesis
    1. at no point hi should be larger than 0
    2. there should be balance between left and right paranthesis

Time: O(n)
Space: O(n)
*/