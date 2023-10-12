class Solution {

    int fun(int ind1,int ind2,String str1,String str2,int dp[][]){

        if(ind1==0 || ind2==0){
            return 0;
        }

        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }

        if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
            return dp[ind1][ind2]=1+fun(ind1-1,ind2-1,str1,str2,dp);
        }
        else {
            return dp[ind1][ind2]=Math.max(fun(ind1-1,ind2,str1,str2,dp),fun(ind1,ind2-1,str1,str2,dp));
        }
    }


    public int longestCommonSubsequence(String text1, String text2) {
       // "abcde"
       //"ace"
       int dp[][] =new int[text1.length()+1][text2.length()+1];
       
       for(int i=0;i<=text1.length();i++){
           dp[i][0]=0;
       }

       for(int j=0;j<=text2.length();j++){
           dp[0][j]=0;
       }

       for(int ind1=1;ind1<=text1.length();ind1++){
           for(int ind2=1;ind2<=text2.length();ind2++){
                     
             
               if(text1.charAt(ind1-1)==text2.charAt(ind2-1)){
             dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                             }
        else {
             dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                        }      
           
        }
       }
       return dp[text1.length()][text2.length()];
    }
}