
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

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1); 
        }

        return fun(m - 1, n - 1, grid,dp);
    }
}