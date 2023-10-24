class Solution {
    int fun(int ind,int buy,int prices[],int dp[][]){
        if(ind>=prices.length){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==1){
           return dp[ind][buy]=profit=Math.max(-prices[ind]+fun(ind+1,0,prices,dp),0+fun(ind+1,1,prices,dp));
        }
        else{
          return dp[ind][buy]=profit=Math.max(prices[ind]+fun(ind+2,1,prices,dp),0+fun(ind+1,0,prices,dp));
        }
    }
    public int maxProfit(int[] prices) {
         
         int dp[][]=new int[prices.length+2][2];
         for(int ind=prices.length-1;ind>=0;ind--){
             for(int buy=0;buy<=1;buy++){
                  if(buy==1){
            dp[ind][buy]=Math.max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
        }
             else{
           dp[ind][buy]=Math.max(prices[ind]+dp[ind+2][1],0+dp[ind+1][0]);
                }
             }
         }
        return dp[0][1];
    }
}