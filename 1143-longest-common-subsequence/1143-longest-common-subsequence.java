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


    public int longestCommonSubsequence(String text1, String text2) {
       // "abcde"
       //"ace"
       int dp[][] =new int[text1.length()][text2.length()];

       for(int i=0;i<text1.length();i++){
           Arrays.fill(dp[i],-1);
       }

       return fun(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}