import java.util.*;
class Solution {
    int fun(int row,int col,List<List<Integer>> ans,int dp[][]){
        if(row==ans.size()-1)
        {
            return ans.get(row).get(col);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down=fun(row+1,col,ans,dp)+ans.get(row).get(col);
        int dig=fun(row+1,col+1,ans,dp)+ans.get(row).get(col);

        return dp[row][col]=Math.min(down,dig);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
                int dp[][]=new int[triangle.size()][];
                for(int i=0;i<triangle.size();i++)
                {
                    dp[i] = new int[triangle.get(i).size()];
                    Arrays.fill(dp[i],-1);
                }
                int n=triangle.size(); 
                return fun(0,0,triangle,dp);
        }
}