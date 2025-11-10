import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            System.out.println(ch);
            // check closing parenthesis
            if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(ch == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }              
            }else if(ch == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        
        return stack.isEmpty();

//         for (char ch : s.toCharArray()) {
//             // If it's an opening bracket, push the corresponding closing bracket
//             if (ch == '(') {
//                 stack.push(')');
//             } else if (ch == '{') {
//                 stack.push('}');
//             } else if (ch == '[') {
//                 stack.push(']');
//             } else {
//                 // If it's a closing bracket, check if it matches the top of the stack
//                 if (stack.isEmpty() || stack.pop() != ch) {
//                     return false;
//                 }
//             }
//         }

//         // All brackets should be closed
//         return stack.isEmpty();
    }

}
