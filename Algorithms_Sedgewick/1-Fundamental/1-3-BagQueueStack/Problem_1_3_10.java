import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Problem_1_3_10 {
    public static void main(String[] args) {
        StdOut.println(infixToPostFix("11 + 22 * 11"));
        StdOut.println(infixToPostFix("( 11 + 22 ) * 11"));
        StdOut.println(infixToPostFix("( 11 + 22 ) * 33 / 2"));
        StdOut.println(infixToPostFix("( 11 + 22 ) * ( 33 / 44 )"));
        StdOut.println(infixToPostFix("( 11 + 22 * 33 / ( 44 + 1 + 2 ) )"));
        StdOut.println(infixToPostFix("( 4 + 3 ) * 11 + ( 33 - 1 ) / ( 1 + 1 )"));
        StdOut.println(infixToPostFix("2 * 3 / ( 2 - 1 ) + 3 * ( 4 - 1 )"));
    }

    // solution
    // 1. meet ( : push to stack
    // 2. meet ) : pop the stack until get (
    // 3. meet operators :
    //      I. pop the stack until get the operator whose priority high that it
    //      II. push the operator
    // 5. meet numbers : push to stack
    // 6. (after loop) pop all operators which left in stack
    private static String infixToPostFix(String str) {
        Stack<String> operators = new Stack<>();
        StringBuilder output = new StringBuilder();

        String[] numOps = str.split(" ");
        for (String s : numOps) {
            switch (s) {
                case "(" :
                    operators.push(s);
                    break;
                case ")" :
                    while (!operators.peek().equals("(")) {
                        output.append(operators.pop() + " ");
                    }
                    operators.pop(); // remove (
                    break;
                case "+" :
                case "-" :
                case "*" :
                case "/" :
                    while (!operators.isEmpty() && getPriority(s) <= getPriority(operators.peek())) {
                        output.append(operators.pop() + " ");
                    }
                    operators.push(s);
                    break;
                default:
                    output.append(s + " ");
            }
        }

        while (!operators.isEmpty()) {
            output.append(operators.pop() + " ");
        }

        output.append(operators.toString());
        return output.toString();
    }

    private static int getPriority(String operator){
        switch (operator){
            case "#":
                return -1;
            case "(":
                return 0;
            case "+":
            case "-":
                return 1;
            case "/":
            case "*":
                return 2;
        }
        return -1;
    }
}
