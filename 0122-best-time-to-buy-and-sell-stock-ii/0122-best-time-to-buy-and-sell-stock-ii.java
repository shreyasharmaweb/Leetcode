class Solution {
    int fun(int ind, int buy,int arr[],int dp[][]){
        if(ind==arr.length){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
       int profit;
        if(buy==1){
            profit=Math.max(-arr[ind]+fun(ind+1,0,arr,dp),0+fun(ind+1,1,arr,dp));
        }
        else{
            profit=Math.max(arr[ind]+fun(ind+1,1,arr,dp),0+fun(ind+1,0,arr,dp));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,1,prices,dp);
    }
}