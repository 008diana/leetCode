//getting there slowly slowly, tried again after sometime, got it more easily i guess
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorderList = new ArrayList<>();
        postorder(root, postorderList);
        return postorderList;
        
    }

    public static void postorder (TreeNode root, List<Integer> postorderList){
        if(root == null){
            return;
        }
        postorder(root.left, postorderList);
        postorder(root.right, postorderList);
        postorderList.add(root.val);
        return;
    }
}
/*
inorder: left, root, right
preorder: root, left, right
postorder: left, right, root

postorder:
first check left, then right, then root
*/