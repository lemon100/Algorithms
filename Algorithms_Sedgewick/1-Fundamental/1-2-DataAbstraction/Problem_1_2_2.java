import edu.princeton.cs.algs4.*;

public class Problem_1_2_2 {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + " intersects " + intervals[j]);
                }
            }
        }
    }
}
