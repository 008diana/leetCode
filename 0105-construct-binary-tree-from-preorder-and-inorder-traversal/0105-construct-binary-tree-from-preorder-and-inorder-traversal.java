//accidentally solved this
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Convert arrays to lists using streams
        List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());

        TreeNode root = new TreeNode(preorderList.get(0));
        int rootValue = preorderList.get(0);
        int index = inorderList.indexOf(rootValue);
        
        preorderList.remove(0); // Remove the root from preorder list
        
        root.left = construct(preorderList, inorderList.subList(0, index));
        root.right = construct(preorderList, inorderList.subList(index + 1, inorderList.size()));

        return root;
    }

    public TreeNode construct(List<Integer> preorderList, List<Integer> inorderList){
        if (inorderList.isEmpty()) {
            return null;
        }
        
        int rootValue = preorderList.remove(0);
        TreeNode root = new TreeNode(rootValue);

        int index = inorderList.indexOf(rootValue);

        // Recursively build the left and right subtrees
        root.left = construct(preorderList, inorderList.subList(0, index));
        root.right = construct(preorderList, inorderList.subList(index + 1, inorderList.size()));

        return root;
    }
}
