import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Problem_1_3_9 {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )",
                "9",
                "9 + 1",
                "9 + 1 )",
                "9.9 - 1 ) ) * 8 + 10.3 )",
                "9.9 - 1 ) * 8 + 10.3 ) * 2 - 0.001 )",
                "9.9 - 1 ) * 8 + 10.3 ) * 2 - 0.001 ) / 22 + 0.2 ) )",
                "9.9 - 1 ) * 8 + 10.3 ) ) * 2 - 0.001 ) / 22 + 0.2 ) )",
                "9.9 - 1 ) * 8 + 10.3 ) * 2 - 0.001 ) / 22 + 0.2 ) * 1.88"
        };

        for (int x = 0; x < strings.length; x++) {
            Stack<String> nums = new Stack<>();
            Stack<String> operators = new Stack<>();
            String[] numOps = strings[x].split(" ");
            for (int i =  0; i < numOps.length; i++) {
                numOps[i] = numOps[i] + " ";
                if ("+ - * / ".contains(numOps[i])) {
                    operators.push(numOps[i]);
                } else if (") ".equals(numOps[i])) {
                    String a = nums.pop();
                    String b = "", operator = "";
                    if (!nums.isEmpty()) {
                        b = nums.pop();
                        operator = operators.pop();
                    }
                    String newNum = "( " + b + operator + a + ") ";
                    // treat the string as a new number,
                    // ig. ( a + b ) as a number
                    nums.push(newNum);
                } else {
                    nums.push(numOps[i]);
                }
            }
            while (!operators.isEmpty()) {
                String a = nums.pop();
                String b = nums.pop();
                String newNum = b + operators.pop() + a;
                nums.push(newNum);
            }
            StdOut.println(nums.toString());
        }
    }
}
