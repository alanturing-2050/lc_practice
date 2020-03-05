class FindElements {
    Set<Integer> seen = new HashSet<>();

    public FindElements(TreeNode root) {
        fix(root, 0);
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }
    
    private void fix(TreeNode root, int val) {
        if (root == null) return;
        
        root.val = val;
        seen.add(val);
        
        fix (root.left, 2 * val + 1);
        fix (root.right, 2 * val + 2);
    }
}


/** 
https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/

Basic dfs solution

Time: O(n)
Space: O(n) for set

*/