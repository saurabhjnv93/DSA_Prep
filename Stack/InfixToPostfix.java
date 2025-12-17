import java.util.*;
class InfixToPostfix {
    
    static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sbr = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sbr.append(ch); // Operand
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sbr.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // Discard '('
                }
            }
            else { // Operator
                while (!st.isEmpty() && st.peek() != '(' &&
                       precedence(st.peek()) >= precedence(ch)) {
                    sbr.append(st.pop());
                }
                st.push(ch);
            }
        }
        
        while (!st.isEmpty()) {
            sbr.append(st.pop());
        }
        
        return sbr.toString();
    }
     public static void main(String[] args) {
        String infix = "a+b*(c-d)";

        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + infixToPostfix(infix));
    }
  
}
