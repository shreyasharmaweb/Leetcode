class Solution {
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        x = Math.abs(x); // Make x positive for reversal
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            // Check for integer overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            rev = rev * 10 + pop;
        }

        rev = sign * rev; // Restore the original sign
        return rev;
    }
}
