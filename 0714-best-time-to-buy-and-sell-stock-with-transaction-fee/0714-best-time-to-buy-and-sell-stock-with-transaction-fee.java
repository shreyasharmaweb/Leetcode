class Solution {
    int fun(int ind,int buy,int prices[],int fee,int dp[][]){
        if(ind>=prices.length){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==1){
            return dp[ind][buy]=profit=Math.max(-prices[ind]+fun(ind+1,0,prices,fee,dp),0+fun(ind+1,1,prices,fee,dp));
        }
        else{
            return dp[ind][buy]=profit=Math.max(prices[ind] -fee+fun(ind+1,1,prices,fee,dp),0+fun(ind+1,0,prices,fee,dp));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,1,prices,fee,dp);
    }
}