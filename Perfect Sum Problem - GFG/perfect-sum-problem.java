//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution {
    int MOD = 1000000007; // Corrected the value of MOD

    int fun(int ind, int target, int arr[],int dp[][]) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }

            if (target == 0 || target == arr[0]) {
                return 1;
            }

            return 0;
        }
         if(dp[ind][target]!=-1){
             return dp[ind][target];
         }
        int take = 0;
        if (target - arr[ind] >= 0) { // Corrected the condition to include target - arr[ind] == 0
            take = fun(ind - 1, target - arr[ind], arr,dp);
        }
        int notTake = fun(ind - 1, target, arr,dp); // Renamed 'not' to 'notTake' to avoid conflict with the 'not' keyword

        return dp[ind][target]=(notTake + take) % MOD;
    }

    public int perfectSum(int arr[], int n, int sum) {
        int dp[][]=new int[n][sum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n - 1, sum, arr,dp);
    }
}

