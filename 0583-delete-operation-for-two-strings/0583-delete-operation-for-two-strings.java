class Solution {
    int fun(int ind1,int ind2,String str1,String str2,int dp[][]){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return dp[ind1][ind2]=1+fun(ind1-1,ind2-1,str1,str2,dp);
        }
        else {
            return dp[ind1][ind2]=Math.max(fun(ind1-1,ind2,str1,str2,dp),fun(ind1,ind2-1,str1,str2,dp));
        }
    }
    public int minDistance(String word1, String word2) {
        
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcs=fun(word1.length()-1,word2.length()-1,word1,word2,dp);
        return n+m-2*(lcs);
    }
}