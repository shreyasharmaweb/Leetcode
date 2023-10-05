
import java.util.*;

class Solution {
    int fun(int r, int c, int arr[][],int dp[][]) {
        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE; 
        }

        if (r == 0 && c == 0) {
            return arr[r][c];
        }
        if(dp[r][c]!=-1)
        {
            return dp[r][c];
        }
        int upr = fun(r - 1, c, arr,dp);
        int last = fun(r, c - 1, arr,dp);
        return dp[r][c]=Math.min(upr, last) + arr[r][c];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        
        for(int i=0;i<m;i++)
        {    
            for(int j=0;j<n;j++)
            {
                 if(i==0 && j==0){
                     dp[i][j]=grid[i][j];
                 }
                 else if(i<0 || j<0){
                     dp[i][j]=Integer.MAX_VALUE;
                 }
                 else {
                      int upr=Integer.MAX_VALUE;
                      int left=Integer.MAX_VALUE;
                   if(i>0){ upr=dp[i-1][j];}
                   if(j>0){ left=dp[i][j-1];}
                    dp[i][j]=Math.min(upr,left)+grid[i][j];
                 }
            }
        }
    return dp[m-1][n-1];
    }
}