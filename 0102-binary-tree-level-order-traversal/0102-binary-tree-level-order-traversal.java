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
       ArrayDeque<TreeNode> q = new ArrayDeque<>();
       List<List<Integer>> ans= new ArrayList<>();
       if(root==null){
           return new ArrayList<>();
       }
       q.add(root);
        while(q.size()>0){
            int size=q.size();
            List<Integer> sub =new ArrayList<>();
            while(size>0){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                sub.add(q.remove().val);
                size--;
            }
            ans.add(sub);
        }
        return ans;
    }
}