//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    void reverse(int low, int high, StringBuilder S) {
        while (low < high) {
            char temp = S.charAt(low);
            S.setCharAt(low, S.charAt(high));
            S.setCharAt(high, temp);
            low++;
            high--;
        }
    }

    String reverseWords(String S) {
        int start = 0;
        int end = 0;
        StringBuilder result = new StringBuilder(S);

        for (end = 0; end < S.length(); end++) {
            if (S.charAt(end) == '.') {
                reverse(start, end - 1, result);
                start = end + 1;
            }
        }
        reverse(start, S.length() - 1, result);

        return result.toString();
    }
}
