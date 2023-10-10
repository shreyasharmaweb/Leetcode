class Solution {

    int fun(int ind,int target,int arr[],int dp[][]){

        if(ind==0){
            if(target%arr[ind]==0){
                return target/arr[ind];
            }
            else return (int)Math.pow(10,9);
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int nottake=0+fun(ind-1,target,arr,dp);
        int take=(int)Math.pow(10,9);
        if(arr[ind]<=target){
            take=1+fun(ind,target-arr[ind],arr,dp);
        }
        return dp[ind][target]= Math.min(nottake,take);
    }


    public int coinChange(int[] coins, int amount) {


        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans= fun(coins.length-1,amount,coins,dp);
        if(ans>=(int)Math.pow(10,9)){
            return -1;
        }
        else return ans;
    }
}