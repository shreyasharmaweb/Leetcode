class Solution {
    int fun(int ind,int target,int arr[],int dp[][]){
      if(ind==0){ 
        if(target==0 && arr[0]==0){
            return 2;
        }
        if(target==0 ||target==arr[0]){
            return 1;
        }
        return 0;
      }

       if (dp[ind][target] != -1)
            return dp[ind][target];

        int nottake=fun(ind-1,target,arr,dp);
        int take=0;
        if(arr[ind]<=target){
            take=fun(ind-1,target-arr[ind],arr,dp);
        }

        return dp[ind][target]=(nottake+take);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum-target<0){
            return 0;
        }
        if((sum-target)%2==1){
            return 0;
        }
        int s2=(sum-target)/2;

        int dp[][]=new int[nums.length][s2+1];
          for(int i=0;i<nums.length;i++){
              Arrays.fill(dp[i],-1);
          }

        return fun(nums.length-1,s2,nums,dp);
    }
}
