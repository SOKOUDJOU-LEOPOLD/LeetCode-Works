
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        // Set to detect cycles
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            // If we have already seen this number, we are in a cycle
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);

            int total = 0;
            int current = n;
            while (current > 0) {
                int digit = current % 10;  // get last digit
                total += digit * digit;    // square it and add
                current /= 10;             // remove last digit
            }
            n = total;
        }

        return true;
    }
}
