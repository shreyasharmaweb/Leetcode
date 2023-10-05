import java.util.*;
class Solution {
    int fun(int r,int c,int arr[][],int dp[][])
    {   if(r>=0 && c>=0 && arr[r][c]==1){
        return 0;
        }
        if(r==0 && c==0)
        {
            return 1;
        }
        if(r<0||c<0)
        {
            return 0;
        }
         if(dp[r][c]!=-1)
         {
             return dp[r][c];
         }
        int upr=fun(r-1,c,arr,dp);
        int left=fun(r,c-1,arr,dp);
        
         return dp[r][c]=upr+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         
           int m=obstacleGrid.length;
           int n=obstacleGrid[0].length;
           int dp[][]= new int[m][n];
          if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
          {
              return 0;
          }
           for(int i=0;i<m;i++)
           {   
               for(int j=0;j<n;j++)
               {
                   if(i==0 && j==0)
                   {
                       dp[i][j]=1;
                   }
                 else if(i>=0 && j>=0 && obstacleGrid[i][j]==1)
                   {
                       dp[i][j]=0;
                   }
                 else {
                   int upr=0;
                   int left=0;
                   if(i>0){
                       upr=dp[i-1][j];
                   }
                   if(j>0){
                       left=dp[i][j-1];
                   }
                  dp[i][j]=upr+left;
                }
               }
           }
           return dp[m-1][n-1];
    }
}
