//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static Boolean fun(int ind, int target, int arr[], Boolean dp[][]) {
        
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[0] == target;
        }
        if (dp[ind][target] != null) {
            return dp[ind][target];
        }
        boolean nottake = fun(ind - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[ind]) {
            take = fun(ind - 1, target - arr[ind], arr, dp);
        }
        
        return dp[ind][target] = take || nottake;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        Boolean dp[][] = new Boolean[N + 1][sum + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], null);
        }
        return fun(N - 1, sum, arr, dp);
    }
}
