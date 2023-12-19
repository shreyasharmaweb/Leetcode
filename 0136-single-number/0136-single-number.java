class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> hp =new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(hp.containsKey(nums[i])){
                int a=hp.get(nums[i])+1;
                hp.put(nums[i],a);
            }
            else{
                hp.put(nums[i],1);
            }
        }
        int ans=0;
        for (Map.Entry<Integer, Integer> b :hp.entrySet()) {
                      if(b.getValue()==1){
                          ans= b.getKey();
                      }
            }
            return ans;
    }
}