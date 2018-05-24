import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;

public class Problem_1_3_4 {
    public static void main(String[] args) throws IOException {
        StdOut.println(parentheses("[()]{}{[()()]()}"));
        StdOut.println(parentheses("[(])"));
        StdOut.println(parentheses("for (int i = 0; i < s.length(); i++)"));
        StdOut.println(parentheses("FixedCapacityStack<String> stack = new FixedCapacityStack<>(cap);"));
    }

    private static boolean parentheses(String s) {
        Stack<Character> leftNations = new Stack<>();
        leftNations.push('F');

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            // obey the rules : {} > [] > (), and [] cannot contain itself
            switch (ch) {
                case '(' :
                    leftNations.push(ch);
                    break;
                case '[' :
                    if (leftNations.peek() == '[' || leftNations.peek() == '(')
                        return false;
                    else
                        leftNations.push(ch);
                    break;
                case '{' :
                    if (leftNations.peek() == '[' || leftNations.peek() == '(')
                        return false;
                    else
                        leftNations.push(ch);
                    break;
                // right notations start
                case ')' :
                    if (leftNations.pop() != '(')
                        return false;
                    break;
                case ']' :
                    if (leftNations.pop() != '[')
                        return false;
                    break;
                case '}' :
                    if (leftNations.pop() != '{')
                        return false;
            }
        }
        return leftNations.size() <= 1;
    }
}
