import java.util.*;

class Solution {
    // Result list
    List<String> res = new ArrayList<>();
    Map<Character, String> dicto = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        // Edge case: empty input
        if (digits == null || digits.length() == 0) {
            return res;
        }

        // Map of digits to letters
        dicto.put('2', "abc");
        dicto.put('3', "def");
        dicto.put('4', "ghi");
        dicto.put('5', "jkl");
        dicto.put('6', "mno");
        dicto.put('7', "pqrs");
        dicto.put('8', "tuv");
        dicto.put('9', "wxyz");

        // Start DFS
        dfs(0, digits, "");
        return res;
    }
    
    public void dfs(int index, String digits, String curr){
        if(curr.length() == digits.length()){
            res.add(curr);
            return;
        }
        
        for(char ch: dicto.get(digits.charAt(index)).toCharArray()){
            dfs(index+1, digits, curr+ch);
        }
        
    }

// using a String builder
//     private void dfs(int index, String digits, StringBuilder current, List<String> res, Map<Character, String> dicto) {
//         // Base case
//         if (current.length() == digits.length()) {
//             res.add(current.toString());
//             return;
//         }

//         // Get letters mapped to current digit
//         String letters = dicto.get(digits.charAt(index));
//         for (char c : letters.toCharArray()) {
//             current.append(c);              // Choose
//             dfs(index + 1, digits, current, res, dicto); // Explore
//             current.deleteCharAt(current.length() - 1);   // Un-choose (backtrack)
//         }
    
}
