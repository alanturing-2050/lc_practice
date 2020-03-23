class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        
        for (int r = n - 1; r >= 0; r--) {
            for (int c = r+1; c < n; c++) {
                if (s.charAt(r) == s.charAt(c) && (c - r == 1  || dp[r+1][c-1])) {
                    dp[r][c] = true;
                }
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        find(s, dp, 0, new ArrayList<>(), res);
        
        return res;
    }
    
    void find(String s, boolean[][] dp, int idx, List<String> curr, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                curr.add(s.substring(idx, i+1));
                find(s, dp, i+1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

/**
https://leetcode.com/problems/palindrome-partitioning/description/

Solution is based on both dfs and dp. DP is used for fast palindrome checking. 
Then DFS used to build List of palindromes one by one

Time: hard to anylyze but looks more like O(n^2)
Space: O(n^2)

*/