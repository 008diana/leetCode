//understood the queue logic.. getting there slowly slowly
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelorderList = new ArrayList<>();
        if(root == null){
            return levelorderList;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        //levelorderList.add(new List<i>)

        while(!nodes.isEmpty()){
            int levelSize = nodes.size();
            List<Integer> currLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode currNode = nodes.poll();
                currLevel.add(currNode.val);

                if(currNode.left != null){
                    nodes.offer(currNode.left);
                }

                if(currNode.right != null){
                    nodes.offer(currNode.right);
                }
            }

            levelorderList.add(currLevel);

        }
        return levelorderList;
    }
    
}