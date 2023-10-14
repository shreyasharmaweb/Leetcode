class Solution {
    int fun(int ind1, int ind2, StringBuilder str1, StringBuilder str2 ,int dp[][]) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }

        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            return dp[ind1][ind2]=1 + fun(ind1 - 1, ind2 - 1, str1, str2,dp);
        } else {
            return dp[ind1][ind2]=Math.max(fun(ind1 - 1, ind2, str1, str2,dp), fun(ind1, ind2 - 1, str1, str2,dp));
        }
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(s).reverse();

        int dp[][]=new int[str1.length()][str2.length()];

        for(int i=0;i<str1.length();i++){
            Arrays.fill(dp[i],-1);
        }

        return fun(str1.length() - 1, str2.length() - 1, str1, str2,dp);
    }
}
