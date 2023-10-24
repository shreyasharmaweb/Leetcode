class Solution {
    int fun(int ind,int prev_ind,int nums[],int dp[][]){
        if(ind==nums.length){
            return 0;
        }
        if(dp[ind][prev_ind+1]!=-1){
            return dp[ind][prev_ind+1];
        }
        int not=fun(ind+1,prev_ind,nums,dp)+0;
        int take=0;
        if(prev_ind==-1 || nums[ind]>nums[prev_ind]){
            take=1+fun(ind+1,ind,nums,dp);
        }
        return dp[ind][prev_ind+1]=Math.max(not,take);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int [nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,-1,nums,dp);
    }
}