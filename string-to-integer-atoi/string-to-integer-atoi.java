class Solution {
    public int myAtoi(String s) {
        // removing the leading space
        int i = 0;
        int n = s.length();
        while(i<n && s.charAt(i) == ' '){
            i++;
        }
        
        // getting the new char or the sign
        int sign = 1;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)== '-')){
            if(s.charAt(i)== '-') sign = -1;
            i++;
        }
        
        // biuding the integer
        long num = 0;
        while(i<n && Character.isDigit(s.charAt(i))){
            num = num*10 + (s.charAt(i)-'0');
            
            // check if the num is greater than the limit or smaller than the limit break
            if(sign == 1 && num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && sign*num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        return (int)(num*sign);
        
    }
}