//NMS. also go to know that you can add TreeNode to the HashMap! Starting of binary tree journey!
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store all created nodes
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Map to track if a node is a child node
        Map<Integer, Boolean> isChildMap = new HashMap<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            int isLeft = description[2];

            // Retrieve or create the parent node
            // If the parent node exists in the map, retrieve it; otherwise, create a new node
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            // Put the parent node into the map (this ensures the node is in the map)
            nodeMap.put(parentVal, parentNode);

            // Retrieve or create the child node
            // If the child node exists in the map, retrieve it; otherwise, create a new node
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            // Put the child node into the map (this ensures the node is in the map)
            nodeMap.put(childVal, childNode);

            // Attach the child node to the parent node on the correct side based on isLeft value
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Mark the child node as a child in the isChildMap
            isChildMap.put(childVal, true);
            // Ensure the parent node is not marked as a child in the isChildMap
            isChildMap.putIfAbsent(parentVal, false);
        }

        // Find the root node (a node that is not a child of any other node)
        for (Map.Entry<Integer, Boolean> entry : isChildMap.entrySet()) {
            if (!entry.getValue()) {
                return nodeMap.get(entry.getKey());
            }
        }

        return null; // Should not reach here if the input is valid
    }
}

/*
1) first access the first row of the given 2d array, call i nodeVal
2) next if the first value is exists in the binary tree, then traverse to that node.
3) if it does not exist: a) check if it is a parent(figure out)   
                         b) if it is not a parent then create a new node
4) then check the third value: if 1 then add to the left side of the parent, else add to the right.

traversing(
    if nodeVal greater than parent node val, traverse to right
    if nodeVal less than parent node val, traverse to left

)
*/