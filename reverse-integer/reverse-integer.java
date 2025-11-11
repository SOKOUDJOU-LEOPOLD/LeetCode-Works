
class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;  // extract last digit
            x /= 10;             // remove the last digit

            // Check for overflow before multiplying by 10
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE%10)) return 0;
            if (result < Integer.MIN_VALUE / 10 || 
               (result == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE%10)) return 0;

            result = result * 10 + digit;
        }

        return result;
    }
}
