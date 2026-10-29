import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char topo = stack.pop();
                
                if (c == ')' && topo != '(') return false;
                if (c == '}' && topo != '{') return false;
                if (c == ']' && topo != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }
}

public class exercise_20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
    }
}
