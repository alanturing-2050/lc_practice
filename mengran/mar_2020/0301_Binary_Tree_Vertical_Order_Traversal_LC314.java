/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;

        int min = Integer.MAX_VALUE;
        Queue<Integer> cols = new LinkedList();
        Queue<TreeNode> nodes = new LinkedList();
        Map<Integer, List<Integer>> map = new HashMap();
        cols.offer(0);
        nodes.offer(root);
        while(!cols.isEmpty() && !nodes.isEmpty()) {
            TreeNode curNode = nodes.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList());
            }
            map.get(col).add(curNode.val);
            min = Math.min(min, col);
            if(curNode.left != null) {
                cols.offer(col - 1);
                nodes.offer(curNode.left);
            }
            if(curNode.right != null) {
                cols.offer(col + 1);
                nodes.offer(curNode.right);
            }
        }
        while(map.containsKey(min)) {
            res.add(new ArrayList(map.get(min++)));
        }
        return res;
    }
}

/**
Problem: https://leetcode.com/problems/binary-tree-vertical-order-traversal/
Analysis:
Typical BFS problem
because the order should be left -> right so once do bfs should be also left -> right
use min to record the most left value

TimeComplexity: O(n)
SpaceComplexity: O(n)

tag: #Binary Tree #BFS
**/
