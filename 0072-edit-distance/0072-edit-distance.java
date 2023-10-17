class Solution {
    
    int fun(int ind1,int ind2,String str1,String str2,int dp[][]){
        
        if(ind2<0){
          return ind1;
        }
        if(ind1<0){
          return  ind2;
        }
        if(dp[ind1][ind2]!=-1){
          return dp[ind1][ind2];
        }
        if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
            return dp[ind1][ind2]= 0+fun(ind1-1,ind2-1,str1,str2,dp);
        }
        else{
        return dp[ind1][ind2]= Math.min(Math.min(1+fun(ind1,ind2-1,str1,str2,dp),1+fun(ind1-1,ind2,str1,str2,dp)),1+fun(ind1-1,ind2-1,str1,str2,dp));
        }
    }

    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        
        for(int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=word2.length();i++){
            dp[0][i]=i;
        }

        for(int ind1=1;ind1<=word1.length();ind1++){
              for(int ind2=1;ind2<=word2.length();ind2++){
                  if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
            dp[ind1][ind2]= 0+dp[ind1-1][ind2-1];
                 }
                else{
            dp[ind1][ind2]= Math.min(Math.min(1+dp[ind1][ind2-1],1+dp[ind1-1][ind2]),1+dp[ind1-1][ind2-1]);
                    }
              }
        }
        return dp[word1.length()][word2.length()];
    }
}