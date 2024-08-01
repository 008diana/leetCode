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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p == null && q == null) {
        return true;
       }

       if (p == null || q == null){
        return false;
       }

       if (p.val != q.val){
        return false;
       }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//my attempt
/*
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null|| q == null){
            return;
        }

        TreeNode leftSub = isSameTree(p.left, q.left);
        TreeNode rightSub = isSameTree(p.right, q.right);

        if (p.left.val != q.left.val && p.right.val != q.right.val) {
            return false;
        }

     return true;
    }
}
*/