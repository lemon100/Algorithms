package DataAbstraction;

import edu.princeton.cs.algs4.*;

public class Ex_1_2_3 {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final double min = Double.parseDouble(args[1]);
        final double max = Double.parseDouble(args[2]);

        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.002);

        Point2D[] x1y1 = new Point2D[N];
        Point2D[] x2y2 = new Point2D[N];
        Interval2D[] interval2Ds = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double left = StdRandom.uniform(min, max);
            double right = StdRandom.uniform(min, max);
            double top = StdRandom.uniform(min, max);
            double bottom = StdRandom.uniform(min, max);
            Interval1D x, y;
            if (left > right) {
                double temp = right;
                right = left;
                left = temp;
            }
            if (bottom > top) {
                double temp = bottom;
                bottom = top;
                top = temp;
            }
            x = new Interval1D(left, right);
            y = new Interval1D(bottom, top);
            x1y1[i] = new Point2D(left, top);
            x2y2[i] = new Point2D(right, bottom);
            interval2Ds[i] = new Interval2D(x, y);
            interval2Ds[i].draw();
        }

        int containAmount = 0, intersectAmount = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((interval2Ds[i].contains(x1y1[j]) && interval2Ds[i].contains(x2y2[j])) ||
                        (interval2Ds[j].contains(x1y1[i]) && interval2Ds[j].contains(x2y2[i]))) {
                    containAmount++;
                    continue; // exclude contain as intersect
                }
                if (interval2Ds[i].intersects(interval2Ds[j])) {
                    intersectAmount++;
                }
            }
        }
        StdOut.println("Contains : " + containAmount);
        StdOut.println("Intersects : " + intersectAmount);
    }
}
