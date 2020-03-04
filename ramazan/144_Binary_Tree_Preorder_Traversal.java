class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);
            
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }
        
        return res;
    }
}


/**
https://leetcode.com/problems/binary-tree-preorder-traversal/description/

Given a binary tree, return the preorder traversal of its nodes' values.


Recursive solution is trivial. Iterrative is somewhat is more tricky, but still straighforward

Time: O(n) 
Space: O(n) for stack
*/