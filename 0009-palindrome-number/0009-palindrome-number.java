public class Solution {
    public boolean isPalindrome(int x) {
        // If x is negative or ends with a zero (except for 0 itself), it can't be a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversed = 0;
        int original = x;
        
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            reversed = reversed * 10 + pop;
        }
        
        return original == reversed;
    }
}
