class Solution {
    int fun(int ind,int target,int arr[],int dp[][]){
    
        if(ind==0){
            if(target%arr[ind]==0){
                return 1;
            }
            else {
                return 0;
            }
        }
            if(dp[ind][target]!=-1){
                return dp[ind][target];
            }

            int nottake=fun(ind-1,target,arr,dp);
            int take=0;
            if(arr[ind]<=target){
                take=fun(ind,target-arr[ind],arr,dp);
            }
            return dp[ind][target]= nottake+take;
        }
         public int change(int amount, int[] coins) {
        
         int dp[][]=new int[coins.length][amount+1];

         for(int i=0;i<coins.length;i++){
               Arrays.fill(dp[i],-1);
         }
        return fun(coins.length-1,amount,coins,dp);
       }
    }
