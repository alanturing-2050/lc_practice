/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
       int[] counts = new int[10];
        preOrder(root, counts);
        return count;
    }

    public void preOrder(TreeNode root, int[] counts) {
        if(root == null) return;
        counts[root.val]++;
        //find leaf node
        if(root.left == null && root.right == null) {
          //check palindrome
            if(isPanlindrome(counts)) count++;
            // backtracking
            counts[root.val]--;
            return;
        }
            preOrder(root.left, counts);
            preOrder(root.right, counts);
            //backtracking
         counts[root.val]--;
        }

// check palindrome
    public boolean isPanlindrome(int[] counts) {
        int countOdd = 0;
        for (int f : counts) {
            if (f % 2 == 1) {
                if (countOdd == 0) countOdd++;
                else return false;
            }
        }
        return true;
    }
}



/**
Problem: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
Analysis: Can be solved with preOrder traversal
use int[] counts represent the frequency of each number
if it is palindrome then count++;
TimeComplexity: O(N)
SpaceComplexity: O(N)
tag: #Binary Tree
**/
