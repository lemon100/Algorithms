import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Problem_1_3_11 {
    public static void main(String[] args) {
        StdOut.println(evalutePostfix("11 22 11 * +"));
        StdOut.println(evalutePostfix("11 22 + 11 *"));
        StdOut.println(evalutePostfix("11 22 + 33 * 2 /"));
        StdOut.println(evalutePostfix("11 22 + 33 44 / *"));
        StdOut.println(evalutePostfix("11 22 33 * 44 1 + 2 + / +"));
        StdOut.println(evalutePostfix("4 3 + 11 * 33 1 - 1 1 + / +"));
        StdOut.println(evalutePostfix("2 3 * 2 1 - / 3 4 1 - * +"));
    }

    private static String evalutePostfix(String expression) {

        Stack<String> digitalNumber = new Stack<>();
        String[] values = expression.split(" ");
        for (String value : values) {
            if ("+-/*".contains(value)) {
                double result = 0.0;
                double value2 = Double.parseDouble(digitalNumber.pop());
                double value1 = Double.parseDouble(digitalNumber.pop());
                switch (value) {
                    case "+" :
                        result = value1 + value2;
                        break;
                    case "-" :
                        result = value1 - value2;
                        break;
                    case "*" :
                        result = value1 * value2;
                        break;
                    case "/" :
                        result = value1 / value2;
                }
                digitalNumber.push(result + "");
            } else {
                digitalNumber.push(value);
            }
        }
        return digitalNumber.pop();
    }
}
