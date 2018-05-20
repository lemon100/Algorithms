import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Problem_1_2_6 {
    public static void main(String[] args) {
        String s = StdIn.readString();
        String t = StdIn.readString();

        if (s.length() == t.length() && s.concat(s).contains(t)) {
            StdOut.println("They are circular rotation");
        } else {
            StdOut.println("They are not circular rotation");
        }
    }
}
