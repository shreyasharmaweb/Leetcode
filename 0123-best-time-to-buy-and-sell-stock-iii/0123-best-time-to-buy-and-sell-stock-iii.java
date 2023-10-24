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
        int dp[][][]=new int[prices.length][2][3];
         for(int i=0;i<prices.length;i++){
             for(int j=0;j<2;j++){
                 Arrays.fill(dp[i][j],-1);
             }
         }
        return fun(0,1,2,prices,dp);
    }
}