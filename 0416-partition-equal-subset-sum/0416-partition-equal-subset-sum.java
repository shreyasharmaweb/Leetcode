import java.util.*;
class Solution {
    boolean fun(int ind,int target,int arr[],Boolean dp[][]){
        if(ind==0){
            return arr[0]==target;
        }
        if(target==0){
            return true;
        }
        if(dp[ind][target]!=null){
            return dp[ind][target];
        }
        boolean nottake=fun(ind-1,target,arr,dp);
        boolean take=false;
        if(target>arr[ind]){
            take=fun(ind-1,target-arr[ind],arr,dp);
        }
        return dp[ind][target]=take||nottake;
    }
 public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
    if (sum % 2 != 0) {
        return false;
    }
    Boolean dp[][] = new Boolean[nums.length][sum / 2 + 1];
    for (int ind = 0; ind < nums.length; ind++) {
        for (int target = 0; target <= sum / 2; target++) {
            if (target == 0) {
                dp[ind][target] = true;
            } else if (ind == 0) {
                dp[ind][target] = (nums[0] == target);
            } else {
                boolean nottake = dp[ind - 1][target];
                boolean take = false;
                if (target >= nums[ind]) {
                    take = dp[ind - 1][target - nums[ind]];
                }
                dp[ind][target] = take || nottake;
            }
        }
    }
    return dp[nums.length - 1][sum / 2];
  }
}