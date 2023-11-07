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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
         if (root == null) {
              return new ArrayList<>();
            }
         Boolean flag=true;
        List<List<Integer>> ans=new ArrayList<>();
        q.offer(root);
      
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> al =new ArrayList<>(size);
            while(size>0){
                if(q.peek().left!=null){
                   q.offer(q.peek().left);
                 }
                
               if(q.peek().right!=null){
                q.offer(q.peek().right);
                } 
                 if(flag==true){
                     al.add(q.poll().val);
                 }
                 else{
                     al.add(0,q.poll().val);
                 }
                 size--;
               }
                flag=!flag;
                 ans.add(al);
            }
          return ans;
        }
        
    }
