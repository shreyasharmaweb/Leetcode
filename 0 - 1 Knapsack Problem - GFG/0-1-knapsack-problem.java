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
    static int fun(int ind,int w,int wt[],int val[],int dp[][]){
           
           if(ind==0){
               if(wt[0]<=w){
                   return val[0];
               }
               else{
                   return 0;
               }
           }
           if(dp[ind][w]!=-1){
               return dp[ind][w];
           }
           int not=fun(ind-1,w,wt,val,dp);
           int take=Integer.MIN_VALUE;
           if(wt[ind]<=w){
               take=fun(ind-1,w-wt[ind],wt,val,dp)+val[ind];
           }
           
           return dp[ind][w]=Math.max(not,take);
           
    }
    static int knapSack(int W, int wt[], int val[], int n) {
         int dp[][]=new int[val.length][W+1];
         for(int i=0;i<dp.length;i++){
             Arrays.fill(dp[i],-1);
         }
         return fun(n-1,W,wt,val,dp);
   }

}


