class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ')' || ch == '(') {
                if (ch == ')') {
                    if (st.isEmpty()) continue;
                    else {
                        sb.append(')');
                        st.pop();
                    }
                } else {
                    sb.append('(');
                    st.push(sb.length());
                }
            } else {
                sb.append(ch);
            }   
        }
        
        while (!st.isEmpty()) sb.deleteCharAt(st.pop()-1);
        
        return sb.toString();
    }
}

/**
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

Create StringBuilder and right parenthesis only if there is matching left in stack.
At the end remove all extra unmatching left parenthesis using indeces in stack starting from right of the stringbuilder.


Time: O(n)
Space: O(n)
*/