class Solution {
    public void moveZeroes(int[] nums) {
        int j=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                  j=i;
                 break;
            }
        }
       int i=j+1;

       while(i<nums.length){
           if(nums[i]!=0){
               int temp=nums[i];
               nums[i]=nums[j];
               nums[j]=temp;
               i++;
               j++;
           }
           else{
               i++;
           }
       }
       
    }
}