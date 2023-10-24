class Solution {
    int fun(int ind ,int buy,int k,int prices[],int dp[][][]){
        if(ind==prices.length){
            return 0;
        }
        if(k==0){
            return 0;
        }
        if(dp[ind][buy][k]!=-1){
            return dp[ind][buy][k];
        }
        int profit=0;
        if(buy==1){
          return dp[ind][buy][k] = profit=Math.max(-prices[ind]+fun(ind+1,0,k,prices,dp),0+fun(ind+1,1,k,prices,dp));
        }
        else{
         return dp[ind][buy][k] = profit=Math.max(prices[ind]+fun(ind+1,1,k-1,prices,dp),0+fun(ind+1,0,k,prices,dp));
        }
    }
   public int maxProfit(int k, int[] prices) {
    int dp[][][] = new int[prices.length + 1][2][k + 1];
    
    for (int ind = prices.length - 1; ind >= 0; ind--) {
        for (int buy = 0; buy <= 1; buy++) {
            for (int ki = 1; ki <= k; ki++) { // Use ki here instead of k
                if (buy == 1) {
                    dp[ind][buy][ki] = Math.max(-prices[ind] + dp[ind + 1][0][ki], 0 + dp[ind + 1][1][ki]);
                } else {
                    dp[ind][buy][ki] = Math.max(prices[ind] + dp[ind + 1][1][ki - 1], 0 + dp[ind + 1][0][ki]);
                }
            }
        }
    }

    return dp[0][1][k];
   }

}