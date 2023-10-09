//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int fun(int ind,int max,int wt[],int val[],int dp[][]){
        
            if(ind==0){
                if(wt[ind]<=max){
                    return val[0];
                }
                else {return 0;}
            }
            
            if(dp[ind][max]!=-1){
                return dp[ind][max];
            }
            
            int not=fun(ind-1,max,wt,val,dp)+0;
            int take=Integer.MIN_VALUE;
            if(wt[ind]<=max){
                take=fun(ind-1,max-wt[ind],wt,val,dp)+val[ind];
            }
        
           return  dp[ind][max] = Math.max(not,take);
    }
    
    
    static int knapSack(int W, int wt[], int val[], int n) {
    int dp[][] = new int[n][W+1];

    for (int i = 0; i <= W; i++) {
        if (wt[0] <= i) {
            dp[0][i] = val[0];
        }
    }

    for (int ind = 1; ind < n; ind++) {
        for (int max = 0; max <= W; max++) {
            int not = dp[ind-1][max];
            int take = Integer.MIN_VALUE;
            if (wt[ind] <= max) {
                take = dp[ind-1][max-wt[ind]] + val[ind];
            }
            dp[ind][max] = Math.max(not, take);
        }
    }
    return dp[n-1][W];
}

}


