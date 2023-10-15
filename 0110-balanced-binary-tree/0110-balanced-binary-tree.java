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
    int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lh=height(node.left);
        int rh=height(node.right);
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root==null){
            return true;
        }

        int lh=height(root.left);
        int rh=height(root.right);

        if(Math.abs(lh-rh)>1){
            return false;
        }

        boolean checkl= isBalanced(root.left);
        boolean checkr=isBalanced(root.right);

        if(checkl==false || checkr==false){return false;}
        return true;
    }
}