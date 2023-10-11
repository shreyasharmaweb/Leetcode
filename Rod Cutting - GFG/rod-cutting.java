//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    int fun(int ind,int n,int price[],int dp[][]){
        if(ind==0){
            return price[0]*n;
        }
        
        if(dp[ind][n]!=-1){
            return dp[ind][n];
        }
        
        int nottake=fun(ind-1,n,price,dp)+0;
        int take=Integer.MIN_VALUE;
        int rodl=ind+1;
        if(rodl<=n){
            take=fun(ind,n-rodl,price,dp)+price[ind];
        }
        return dp[ind][n]=Math.max(nottake,take);
    }
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,n,price,dp);
    }
}