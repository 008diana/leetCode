//can't seem to get recursionnnnn
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
    public int goodNodes(TreeNode root) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        return countGoodNodes(root, maxHeap);
    } 

    private int countGoodNodes(TreeNode node, PriorityQueue<Integer> maxHeap) {
        if (node == null) {
            return 0;
        }

        int goodNodeCount = 0;

        // If the max-heap is empty or the current node's value is greater than or equal to
        // the max in the heap, it's a good node
        if (maxHeap.isEmpty() || node.val >= maxHeap.peek()) {
            goodNodeCount = 1;
        }

        // Add the current node's value to the max-heap
        maxHeap.offer(node.val);

        // Recursively check the left and right children
        goodNodeCount += countGoodNodes(node.left, maxHeap);
        goodNodeCount += countGoodNodes(node.right, maxHeap);

        // Remove the current node's value from the max-heap as we backtrack
        maxHeap.remove(node.val);

        return goodNodeCount;
    }
}