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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode roott=root;
        while(true){
            if(roott.val>val){
                if(roott.left!=null){
                    roott=roott.left;
                }
                else{
                    roott.left=new TreeNode(val);
                    break;
                }
            }
            else{
                 if(roott.right!=null){
                   roott=roott.right;
                }
                 else{
                    roott.right=new TreeNode(val);
                    break;
                    }
                 }
            }
            return root;
        }
    }
