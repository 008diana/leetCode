// not my code. i undestand it fully. introducing a temporary variable to make it more undersandable from my end
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // Swap the left and right children using a temporary variable
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }
}
