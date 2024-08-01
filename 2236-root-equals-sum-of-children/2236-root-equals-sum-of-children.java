//this is the sexond bianry tree Q I've gotten correct. Literally, took me 10 seconds! Am writing this before submitiing even, that much confidence I have XD. anyways feels nice toget some easy ones in!
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
    public boolean checkTree(TreeNode root) {
        if(root.val == root.left.val + root.right.val) {
            return true;
        }
        return false;
    }
}