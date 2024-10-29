//once you get of of the three right, you get the rest rigth easily
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return inorderList;
    }

    public static List<Integer> inorder (TreeNode root, List<Integer> inorderList){
        if(root == null){
            return inorderList;
        }

        inorder(root.left,inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);

        return inorderList;
    }
}