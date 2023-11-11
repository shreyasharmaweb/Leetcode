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

    public TreeNode find(int []pre,int prestart,int preend,int []in,int instart ,int inend,HashMap <Integer,Integer> mp){
        if(prestart>preend || instart>inend){
            return null;
        }
        TreeNode node=new TreeNode(pre[prestart]);
        int inroot=mp.get(pre[prestart]);
        int numleft=inroot-instart;

        node.left=find(pre,prestart+1,prestart+numleft,in,instart,inroot-1,mp);
        node.right=find(pre,prestart+numleft+1,preend,in,inroot+1,inend,mp);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap <Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
               mp.put(inorder[i],i);
        } 
        TreeNode root=find(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mp);
        return root;
    }
}