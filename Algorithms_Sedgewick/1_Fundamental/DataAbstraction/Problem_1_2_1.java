package DataAbstraction;

import edu.princeton.cs.algs4.*;

public class Problem_1_2_1 {
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);

        StdDraw.setCanvasSize(700, 700);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.02);

        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        // calculate the minimum distance
        double minDistance;
        int x = 0, y = 0;
        if (n > 1) {
            minDistance = points[0].distanceTo(points[1]);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double tempDistance = points[i].distanceTo(points[j]);
                    if (tempDistance < minDistance) {
                        minDistance = tempDistance;
                        x = i;
                        y = j;
                    }
                }
            }
        } else {
            minDistance = 0;
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        points[x].drawTo(points[y]);
        StdOut.println("Minimum distance is :" + minDistance);
    }
}
