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
    void right(TreeNode root, List<Integer> al,int level){
        if(root==null){
            return;
        }
        if(level==al.size()){
            al.add(root.val);
        }
        right(root.right,al,level+1);
        right(root.left,al,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al= new ArrayList<>();
        right(root,al,0);
        return al;
    }
}