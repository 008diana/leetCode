//little little hang of this
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        return preorderList;
    }

    public static List<Integer> preorder(TreeNode root, List<Integer> preorderList) {
        
        if(root == null){
            return preorderList;
        }

        preorderList.add(root.val);   
        preorder(root.left, preorderList);
        preorder(root.right, preorderList);
        return preorderList;
    }
}