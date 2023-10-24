class Solution {
    int fun(int ind,int buy,int cap,int arr[],int dp[][][]){
        
        if(cap==0){
            return 0;
        }
        if(ind==arr.length){
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int profit=0;
        if(buy==1){
       return dp[ind][buy][cap]=profit=Math.max(-arr[ind]+fun(ind+1,0,cap,arr,dp),0+fun(ind+1,1,cap,arr,dp));
        }
        else{
       return dp[ind][buy][cap]=profit=Math.max(arr[ind]+fun(ind+1,1,cap-1,arr,dp),0+fun(ind+1,0,cap,arr,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length+1][2][3];
        
        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                      
                if(buy==1){
                     dp[ind][buy][cap]=Math.max(-prices[ind]+dp[ind+1][0][cap],0+dp[ind+1][1][cap]);
                    }
                  else{
                    dp[ind][buy][cap]=Math.max(prices[ind]+dp[ind+1][1][cap-1],0+dp[ind+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}