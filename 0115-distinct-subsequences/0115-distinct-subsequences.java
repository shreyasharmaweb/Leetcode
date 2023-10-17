class Solution {
    int fun(int ind1,int ind2,String s,String t,int dp[][]){
        if(ind2<0){
            return 1;
        }
        if(ind1<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1-1)==t.charAt(ind2-1)){
           return  dp[ind1][ind2]= fun(ind1-1,ind2-1,s,t,dp)+fun(ind1-1,ind2,s,t,dp);
        }
        else{
            return dp[ind1][ind2]= fun(ind1-1,ind2,s,t,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int [s.length()+1][t.length()+1];
         
         for(int i=0;i<=s.length();i++){
             dp[i][0]=1;
         }
         for(int j=1;j<=t.length();j++){
             dp[0][j]=0;
         }

         for(int ind1=1;ind1<=s.length();ind1++){
             for(int ind2=1;ind2<=t.length();ind2++){

                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                        dp[ind1][ind2]= dp[ind1-1][ind2-1]+dp[ind1-1][ind2];
                          }
               else{
                         dp[ind1][ind2]= dp[ind1-1][ind2];
                   }
             }
         }
         return dp[s.length()][t.length()];
    }
}