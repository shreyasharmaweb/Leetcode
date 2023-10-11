//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int fun(int ind,int W,int val[],int wt[],int dp[][]){
          if(ind==0){
              return (W/wt[ind])*val[ind];
          }
          
          if(dp[ind][W]!=-1){
              return dp[ind][W];
          }
          
          int nottake=fun(ind-1,W,val,wt,dp)+0;
          int take=Integer.MIN_VALUE;
          if(wt[ind]<=W){
              take=fun(ind,W-wt[ind],val,wt,dp)+val[ind];
          }
          
           return  dp[ind][W]=Math.max(nottake,take);
      }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][]=new int[N][W+1];
        
        for(int i=wt[0];i<=W;i++){
            dp[0][i]=(i/wt[0])*val[0];
        }
        
        for(int ind=1;ind<N;ind++){
            for(int maxi=0;maxi<=W;maxi++){
                   int nottake=dp[ind-1][maxi]+0;
                   int take=Integer.MIN_VALUE;
                   if(wt[ind]<=maxi){
                       take=dp[ind][maxi-wt[ind]]+val[ind];
                         }
          
                 dp[ind][maxi]=Math.max(nottake,take);
                
            }
        }
        return dp[N-1][W];
    }
}